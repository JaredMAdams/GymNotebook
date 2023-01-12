import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Set } from '../interfaces/set';

@Injectable({
  providedIn: 'root'
})
export class SetService {

  constructor(private http: HttpClient) { }

  setUrl = `${environment.baseUrl}/sets`;

  getSetById(setId: number): Observable<Set> {
    return this.http.get<Set>(`${this.setUrl}/` + setId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllSets(): Observable<Set[]> {
    return this.http.get<Set[]>(`${this.setUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getSetsByWorkoutExerciseId(workoutExerciseId: number): Observable<Set[]> {
    return this.http.get<Set[]>(`${this.setUrl}/workout-exercise/` + workoutExerciseId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postSet(set: Set): Observable<Set> {
    return this.http.post<Set>(`${this.setUrl}`, JSON.stringify(set), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  postMultipleSets(sets: Set[]): Observable<Set[]> {
    return this.http.post<Set[]>(`${this.setUrl}`, JSON.stringify(sets), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putSet(set: Set): Observable<Set> {
    return this.http.put<Set>(`${this.setUrl}`,JSON.stringify(set), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deleteSet(setId: number): Observable<Set> {
    return this.http.delete<Set>(`${this.setUrl}/` + setId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
