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
  
  get(id: string): Observable<any> {
    let result: Observable<Object>;
    result = this.http.get(this.API + '/usuarios' + '/' + id);
    return result;
  }

  save(usuario: any): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(this.API + '/usuarios' + '/save', usuario);
    return result;
  }

  remove(usuario: any): Observable<any> {
    let result: Observable<Object>;
    result = this.http.delete(this.API + '/usuarios' + '/delete' + usuario.id);
    return result;
  }
}
