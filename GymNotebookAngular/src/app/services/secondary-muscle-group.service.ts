import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SecondaryMuscleGroup } from '../interfaces/secondary-muscle-group';

@Injectable({
  providedIn: 'root'
})
export class SecondaryMuscleGroupService {

  constructor(private http: HttpClient) { }

  secondaryMuscleGroupUrl = `${environment.baseUrl}/secondaries`;

  getSecondaryMuscleGroupById(secondaryMuscleGroupId: number): Observable<SecondaryMuscleGroup> {
    return this.http.get<SecondaryMuscleGroup>(`${this.secondaryMuscleGroupUrl}/` + secondaryMuscleGroupId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllSecondaryMuscleGroups(): Observable<SecondaryMuscleGroup[]> {
    return this.http.get<SecondaryMuscleGroup[]>(`${this.secondaryMuscleGroupUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getSecondariesByExercise(exerciseId: number): Observable<SecondaryMuscleGroup[]> {
    return this.http.get<SecondaryMuscleGroup[]>(`${this.secondaryMuscleGroupUrl}/exercise/` + exerciseId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postSecondaryMuscleGroup(muscleGroup: SecondaryMuscleGroup[]): Observable<SecondaryMuscleGroup[]> {
    return this.http.post<SecondaryMuscleGroup[]>(`${this.secondaryMuscleGroupUrl}`, JSON.stringify(muscleGroup), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putSecondaryMuscleGroup(muscleGroup: SecondaryMuscleGroup): Observable<SecondaryMuscleGroup> {
    return this.http.put<SecondaryMuscleGroup>(`${this.secondaryMuscleGroupUrl}`, JSON.stringify(muscleGroup), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deleteSecondaryMuscleGroup(secondaryMuscleGroupId: number): Observable<SecondaryMuscleGroup> {
    return this.http.delete<SecondaryMuscleGroup>(`${this.secondaryMuscleGroupUrl}/` + secondaryMuscleGroupId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
