import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Login } from '../interfaces/login';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { User } from '../interfaces/user';
import { UserModel } from '../models/user-model';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authUrl: string = `${environment.baseUrl}/auth`
  currentUser!: UserModel;
  
  constructor(private http: HttpClient) { }

  login(login: Login): Observable<User> {
    const res = this.http.post<User>(`${this.authUrl}/login`, JSON.stringify(login), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );

    res.subscribe((data) => {
      this.currentUser.userId = data.userId;
      this.currentUser.firstName = data.firstName;
      this.currentUser.lastName = data.lastName;
      this.currentUser.weight = data.weight;
    })
    return res;
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
