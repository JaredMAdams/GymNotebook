import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Exercise } from '../interfaces/exercise';
import { Observable, catchError, retry, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService {

  constructor(private http: HttpClient) { }

  exerciseUrl = `${environment.baseUrl}/exercises`;

  getExerciseById(exerciseId: number): Observable<Exercise> {
    return this.http.get<Exercise>(`${this.exerciseUrl}/` + exerciseId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllExercises(): Observable<Exercise[]> {
    return this.http.get<Exercise[]>(`${this.exerciseUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getExercisesByPrimaryMuscle(primaryMuscle: string): Observable<Exercise[]> {
    return this.http.get<Exercise[]>(`${this.exerciseUrl}/primary/` + primaryMuscle, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getExercisesByCardio(): Observable<Exercise[]> {
    return this.http.get<Exercise[]>(`${this.exerciseUrl}/cardio`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getExercisesByStrength(): Observable<Exercise[]> {
    return this.http.get<Exercise[]>(`${this.exerciseUrl}/strength`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postExercise(exercise: Exercise): Observable<Exercise> {
    return this.http.post<Exercise>(`${this.exerciseUrl}`, JSON.stringify(exercise), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putExercise(exercise: Exercise): Observable<Exercise> {
    return this.http.put<Exercise>(`${this.exerciseUrl}`, JSON.stringify(exercise), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deleteExercise(exerciseId: number): Observable<Exercise> {
    return this.http.delete<Exercise>(`${this.exerciseUrl}/` + exerciseId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
