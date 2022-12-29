import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Page } from '../interfaces/page';

@Injectable({
  providedIn: 'root'
})
export class PageService {

  constructor(private http: HttpClient) { }

  pageUrl = `${environment.baseUrl}/pages`;

  getPageById(pageId: number): Observable<Page> {
    return this.http.get<Page>(`${this.pageUrl}/` + pageId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllPages(): Observable<Page[]> {
    return this.http.get<Page[]>(`${this.pageUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getPagesByNotebook(notebookId: number): Observable<Page[]> {
    return this.http.get<Page[]>(`${this.pageUrl}/notebook/` + notebookId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postPage(page: Page): Observable<Page> {
    return this.http.post<Page>(`${this.pageUrl}`, JSON.stringify(page), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putPage(page: Page): Observable<Page> {
    return this.http.put<Page>(`${this.pageUrl}`, JSON.stringify(page), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deletePage(pageId: number): Observable<Page> {
    return this.http.delete<Page>(`${this.pageUrl}/` + pageId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
