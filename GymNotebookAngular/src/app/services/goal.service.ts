import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Goal } from '../interfaces/goal';

@Injectable({
  providedIn: 'root'
})
export class GoalService {

  constructor(private http: HttpClient) { }

  goalUrl = `${environment.baseUrl}/goals`

  getGoalById(goalId: number): Observable<Goal> {
    return this.http.get<Goal>(`${this.goalUrl}/` + goalId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getAllGoals(): Observable<Goal[]> {
    return this.http.get<Goal[]>(`${this.goalUrl}`, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  getGoalsByUser(userId: number): Observable<Goal[]> {
    return this.http.get<Goal[]>(`${this.goalUrl}/user/` + userId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  postGoal(goal: Goal): Observable<Goal> {
    return this.http.post<Goal>(`${this.goalUrl}`, JSON.stringify(goal), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  putGoal(goal: Goal): Observable<Goal> {
    return this.http.put<Goal>(`${this.goalUrl}`, JSON.stringify(goal), {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }

  deleteGoal(goalId: number): Observable<Goal> {
    return this.http.delete<Goal>(`${this.goalUrl}/` + goalId, {headers: environment.headers, withCredentials: environment.withCredentials}).pipe(
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
