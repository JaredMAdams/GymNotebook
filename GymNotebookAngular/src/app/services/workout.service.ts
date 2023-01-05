import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Workout } from '../interfaces/workout';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {

  constructor(private http: HttpClient) { }

  workoutUrl = `${environment.baseUrl}/workouts`;

  getWorkoutById(workoutId: number): Observable<Workout> {
    return this.http.get<Workout>(`${this.workoutUrl}/` + workoutId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllWorkouts(): Observable<Workout[]> {
    return this.http.get<Workout[]>(`${this.workoutUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getWorkoutsByPageId(pageId: number): Observable<Workout[]> {
    return this.http.get<Workout[]>(`${this.workoutUrl}/page/` + pageId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getWorkoutsByUserId(userId: number): Observable<Workout[]> {
    return this.http.get<Workout[]>(`${this.workoutUrl}/user/` + userId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postWorkout(workout: Workout): Observable<Workout> {
    return this.http.post<Workout>(`${this.workoutUrl}`, JSON.stringify(workout), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putWorkout(workout: Workout): Observable<Workout> {
    return this.http.put<Workout>(`${this.workoutUrl}`, JSON.stringify(workout), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deleteWorkout(workoutId: number): Observable<Workout> {
    return this.http.delete<Workout>(`${this.workoutUrl}/` + workoutId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
