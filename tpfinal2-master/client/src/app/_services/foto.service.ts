import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})

export class FotoService {

  public API = '//localhost:8080';
  public FOTO_API = this.API + '/fotos';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/fotos');
  }
  
  get(id: string) {
    return this.http.get(this.FOTO_API + '/' + id);
  }

  save(foto: any): Observable<any> {
    let result: Observable<Object>;
    if (foto['href']) {
      result = this.http.put(foto.href, foto);
    } else {
      result = this.http.post(this.FOTO_API + '/save', foto);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
