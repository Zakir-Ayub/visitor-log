import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Visitor } from './visitor';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class VisitorService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getVisitors(): Observable<Visitor[]>
  {
    return this.http.get<any>(`${this.apiServerUrl}/visitor/all`);
  }

  public addVisitor(visitor: Visitor): Observable<Visitor>
  {
    return this.http.post<any>(`${this.apiServerUrl}/visitor/add`, visitor);
  }

  public updateVisitor(visitor: Visitor): Observable<Visitor>
  {
    return this.http.put<any>(`${this.apiServerUrl}/visitor/update`, visitor);
  }

  public deleteVisitor(visitorId: number): Observable<void>
  {
    return this.http.delete<void>(`${this.apiServerUrl}/visitor/delete/${visitorId}`);
  }

}
