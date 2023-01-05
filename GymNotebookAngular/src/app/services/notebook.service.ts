import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Notebook } from '../interfaces/notebook';

@Injectable({
  providedIn: 'root'
})
export class NotebookService {

  constructor(private http: HttpClient) { }

  notebookUrl = `${environment.baseUrl}/notebooks`

  getNotebookById(notebookId: number): Observable<Notebook> {
    return this.http.get<Notebook>(`${this.notebookUrl}/` + notebookId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllNotebooks(): Observable<Notebook[]> {
    return this.http.get<Notebook[]>(`${this.notebookUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getNotebookByUser(userId: number): Observable<Notebook> {
    return this.http.get<Notebook>(`${this.notebookUrl}/user/` + userId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postNotebook(notebook: Notebook): Observable<Notebook> {
    return this.http.post<Notebook>(`${this.notebookUrl}`, JSON.stringify(notebook), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putNotebook(notebook: Notebook): Observable<Notebook> {
    return this.http.put<Notebook>(`${this.notebookUrl}`, JSON.stringify(notebook), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deleteNotebook(notebookId: number): Observable<Notebook> {
    return this.http.delete<Notebook>(`${this.notebookUrl}/` + notebookId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
