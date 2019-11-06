import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})

export class PersonaService {
  public API = '//localhost:8080';
  public PERSONA_API = this.API + '/personas';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/personas');
  }
  
  get(id: string) {
    return this.http.get(this.PERSONA_API + '/' + id);
  }

  save(persona: any): Observable<any> {
    let result: Observable<Object>;
    if (persona['href']) {
      result = this.http.put(persona.href, persona);
    } else {
      result = this.http.post(this.PERSONA_API + '/save', persona);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
