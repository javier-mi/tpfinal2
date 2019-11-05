import { UsuarioDetail } from './../_models/usuario-detail';
import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { delay, mergeMap, materialize, dematerialize } from 'rxjs/operators';

import { Usuario } from '../_models/usuario';

const myUsuariodetails: UsuarioDetail = { 
	password: "test", 
	usuarioname: "test", 
	usuarioDetails: null, 
	accountNonExpired: true, 
	accountNonLocked: true,
    credentialsNonExpired: true, 
    enabled: true
}

const usuarios: Usuario[] = [{ usuarioDetails: myUsuariodetails }];

@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const { url, method, headers, body } = request;

        // wrap in delayed observable to simulate server api call
        return of(null)
            .pipe(mergeMap(handleRoute))
            .pipe(materialize()) // call materialize and dematerialize to ensure delay even if an error is thrown (https://github.com/Reactive-Extensions/RxJS/issues/648)
            .pipe(delay(500))
            .pipe(dematerialize());

        function handleRoute() {
            switch (true) {
                case url.endsWith('/usuarios/authenticate') && method === 'POST':
                    return authenticate();
                case url.endsWith('/usuarios') && method === 'GET':
                    return getUsuarios();
                default:
                    // pass through any requests not handled above
                    return next.handle(request);
            }    
        }

        // route functions

        function authenticate() {
            const { usuarioname, password } = body;
            const usuario = usuarios.find(x => x.usuarioDetails.usuarioname === usuarioname && x.usuarioDetails.password === password);
            if (!usuario) return error('Usuario o Password incorrectos');
            return ok({
                usuarioDetails: usuario,
                jwttoken: 'fake-jwt-token'
            })
        }

        function getUsuarios() {
            if (!isLoggedIn()) return unauthorized();
            return ok(usuarios);
        }

        // helper functions

        function ok(body?) {
            return of(new HttpResponse({ status: 200, body }))
        }

        function error(message) {
            return throwError({ error: { message } });
        }

        function unauthorized() {
            return throwError({ status: 401, error: { message: 'Unauthorised' } });
        }

        function isLoggedIn() {
            return headers.get('Authorization') === 'Bearer fake-jwt-token';
        }
    }
}

export let fakeBackendProvider = {
    // use fake backend in place of Http service for backend-less development
    provide: HTTP_INTERCEPTORS,
    useClass: FakeBackendInterceptor,
    multi: true
};