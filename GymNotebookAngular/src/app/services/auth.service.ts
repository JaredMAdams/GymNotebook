import { HttpClient } from '@angular/common/http';
import { Injectable, resolveForwardRef } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Login } from '../interfaces/login';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authUrl: string = `${environment.baseUrl}/auth`
  
  constructor(private http: HttpClient) { }

  login(login: Login): Observable<User> {
    return this.http.post<User>(`${this.authUrl}/login`, JSON.stringify(login), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }
  
  errorHandl(error: any) {
      let errorMessage = '';
      if(error.error instanceof ErrorEvent) {
        // Get client-side error
        errorMessage = error.error.message;
      } else {
        // Get server-side error
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
      }
      console.log(errorMessage);
      return throwError(errorMessage);
  }
}
