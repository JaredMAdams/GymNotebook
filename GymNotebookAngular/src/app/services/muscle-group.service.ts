import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { MuscleGroup } from '../interfaces/muscle-group';

@Injectable({
  providedIn: 'root'
})
export class MuscleGroupService {

  constructor(private http: HttpClient) { }

  muscleGroupUrl = `${environment.baseUrl}/muscle-groups`;

  getMuscleGroupById(muscleGroupId: number): Observable<MuscleGroup> {
    return this.http.get<MuscleGroup>(`${this.muscleGroupUrl}/` + muscleGroupId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllMuscleGroups(): Observable<MuscleGroup[]> {
    return this.http.get<MuscleGroup[]>(`${this.muscleGroupUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postMuscleGroup(muscleGroup: MuscleGroup): Observable<MuscleGroup> {
    return this.http.post<MuscleGroup>(`${this.muscleGroupUrl}`, JSON.stringify(muscleGroup), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  putMuscleGroup(muscleGroup: MuscleGroup): Observable<MuscleGroup> {
    return this.http.put<MuscleGroup>(`${this.muscleGroupUrl}`, JSON.stringify(muscleGroup), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  deleteMuscleGroup(muscleGroupId: number): Observable<MuscleGroup> {
    return this.http.delete<MuscleGroup>(`${this.muscleGroupUrl}/` + muscleGroupId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
