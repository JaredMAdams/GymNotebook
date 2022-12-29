import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { WorkoutMuscleGroup } from '../interfaces/workout-muscle-group';
import { UserMuscleGroup } from '../interfaces/user-muscle-group';


@Injectable({
  providedIn: 'root'
})
export class WorkoutMuscleGroupService {

  constructor(private http: HttpClient) { }

  workoutMuscleGroupUrl = `${environment.baseUrl}/workout-muscle-groups`;

  getWorkoutMuscleGroupById(workoutMuscleGroupId: number): Observable<WorkoutMuscleGroup> {
    return this.http.get<WorkoutMuscleGroup>(`${this.workoutMuscleGroupUrl}/` + workoutMuscleGroupId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllWorkoutMuscleGroup(): Observable<WorkoutMuscleGroup[]> {
    return this.http.get<WorkoutMuscleGroup[]>(`${this.workoutMuscleGroupUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getWorkoutMuscleGroupByWorkout(workoutId: number): Observable<WorkoutMuscleGroup[]> {
    return this.http.get<WorkoutMuscleGroup[]>(`${this.workoutMuscleGroupUrl}/` + workoutId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }
  
  getWorkoutMuscleGroupsByUserAndMuscleGroup(userMuscleGroup: UserMuscleGroup): Observable<WorkoutMuscleGroup[]> {
    return this.http.post<WorkoutMuscleGroup[]>(`${this.workoutMuscleGroupUrl}/muscle-group`, JSON.stringify(userMuscleGroup), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postWorkoutMuscleGroup(workoutMuscleGroup: WorkoutMuscleGroup): Observable<WorkoutMuscleGroup> {
    return this.http.post<WorkoutMuscleGroup>(`${this.workoutMuscleGroupUrl}`, JSON.stringify(workoutMuscleGroup), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  postMultipleWorkoutMuscleGroups(workoutMuscleGroups: WorkoutMuscleGroup[]): Observable<WorkoutMuscleGroup[]> {
    return this.http.post<WorkoutMuscleGroup[]>(`${this.workoutMuscleGroupUrl}/multiple`, JSON.stringify(workoutMuscleGroups), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putWorkoutMuscleGroup(workoutMuscleGroup: WorkoutMuscleGroup): Observable<WorkoutMuscleGroup> {
    return this.http.put<WorkoutMuscleGroup>(`${this.workoutMuscleGroupUrl}`, JSON.stringify(workoutMuscleGroup), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deleteWorkoutExercise(workoutMuscleGroupId: number): Observable<WorkoutMuscleGroup> {
    return this.http.delete<WorkoutMuscleGroup>(`${this.workoutMuscleGroupUrl}/` + workoutMuscleGroupId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
