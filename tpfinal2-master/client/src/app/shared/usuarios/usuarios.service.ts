import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class UsuariosService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/usuarios');
  }
  
  get(id: string) {
    return this.http.get(this.API + '/usuarios' + '/' + id);
  }

  save(usuario: any): Observable<any> {
    let result: Observable<Object>;
    alert(result);
    if (usuario['href']) {
      result = this.http.put(usuario.href, usuario);
    } else {
      result = this.http.post(this.API + '/usuarios' + '/save', usuario);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
