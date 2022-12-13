import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProglanguaappService {

  proglanguaappURL = 'http://localhost:8080/programmingLanguages?';
  constructor(private httpClient: HttpClient) { }

  public PrgLang(page: number, size: number, order: string, asc: boolean): Observable<any> {
    return this.httpClient.get<any>(this.proglanguaappURL + `page=${page}&size=${size}&order=${order}&asc=${asc}`);
  }
}
