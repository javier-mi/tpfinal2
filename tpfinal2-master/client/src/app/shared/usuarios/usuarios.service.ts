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
  	alert("getid de usuario service" + id);
    let result: Observable<Object>;
    alert('antes result' + result);
    result = this.http.get(this.API + '/usuarios' + '/' + id);
    alert('despues result' + result);
    return result;
  }

  save(usuario: any): Observable<any> {
    let result: Observable<Object>;
    alert('antes result' + result)
    result = this.http.post(this.API + '/usuarios' + '/save', usuario);
    alert('antes despues' + result) 
    return result;
  }

  remove(usuario: any): Observable<any> {
  	alert("removeid usuario; " + usuario.id);
    let result: Observable<Object>;
    alert('antes result' + result)
    result = this.http.delete(this.API + '/usuarios' + '/delete' + usuario.id);
    alert("despues result" + result);
    return result;
  }
}
