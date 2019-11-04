import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Usuario } from '../_models/usuario';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private currentUsuarioSubject: BehaviorSubject<Usuario>;
  public currentUsuario: Observable<Usuario>;

  constructor(private http: HttpClient) {
      this.currentUsuarioSubject = new BehaviorSubject<Usuario>(JSON.parse(localStorage.getItem('currentUsuario')));
      this.currentUsuario = this.currentUsuarioSubject.asObservable();
  }

  public get currentUsuarioValue(): Usuario {
      return this.currentUsuarioSubject.value;
  }

  login(usuarioname: string, password: string) {
      return this.http.post<any>(`${environment.apiUrl}/authenticate`, { usuarioname, password })
          .pipe(map(usuario => {
              // store usuario details and jwt token in local storage to keep usuario logged in between page refreshes
              localStorage.setItem('currentUsuario', JSON.stringify(usuario));
              this.currentUsuarioSubject.next(usuario);
              return usuario;
          }));
  }

  logout() {
      // remove usuario from local storage to log usuario out
      localStorage.removeItem('currentUsuario');
      this.currentUsuarioSubject.next(null);
  }
}
