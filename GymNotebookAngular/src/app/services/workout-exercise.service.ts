import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { WorkoutExercise } from '../interfaces/workout-exercise';
import { UserExercise } from '../interfaces/user-exercise';

@Injectable({
  providedIn: 'root'
})
export class WorkoutExerciseService {

  constructor(private http: HttpClient) { }

  workoutExerciseUrl = `${environment.baseUrl}/workout-exercises`;

  getWorkoutExerciseById(workoutExerciseId: number): Observable<WorkoutExercise> {
    return this.http.get<WorkoutExercise>(`${this.workoutExerciseUrl}/` + workoutExerciseId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllWorkoutExercises(): Observable<WorkoutExercise[]> {
    return this.http.get<WorkoutExercise[]>(`${this.workoutExerciseUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getWorkoutExercisesByWorkout(workoutId: number): Observable<WorkoutExercise[]> {
    return this.http.get<WorkoutExercise[]>(`${this.workoutExerciseUrl}/workout/` + workoutId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }
  
  getWorkoutExercisesByUserAndExercise(userExercise: UserExercise): Observable<WorkoutExercise[]> {
    return this.http.post<WorkoutExercise[]>(`${this.workoutExerciseUrl}/user-exercise`, JSON.stringify(userExercise), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postWorkoutExercise(workoutExercise: WorkoutExercise): Observable<WorkoutExercise> {
    return this.http.post<WorkoutExercise>(`${this.workoutExerciseUrl}`, JSON.stringify(workoutExercise), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  postMultipleWorkoutExercises(workoutExercise: WorkoutExercise[]): Observable<WorkoutExercise[]> {
    return this.http.post<WorkoutExercise[]>(`${this.workoutExerciseUrl}/multiple`, JSON.stringify(workoutExercise), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putWorkoutExercise(workoutExercise: WorkoutExercise): Observable<WorkoutExercise> {
    return this.http.put<WorkoutExercise>(`${this.workoutExerciseUrl}`, JSON.stringify(workoutExercise), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deleteWorkoutExercise(workoutExerciseId: number): Observable<WorkoutExercise> {
    return this.http.delete<WorkoutExercise>(`${this.workoutExerciseUrl}/` + workoutExerciseId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
