import { Component } from '@angular/core';
import { Workout } from 'src/app/interfaces/workout';
import { Set } from 'src/app/interfaces/set';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { NewWorkoutComponent } from '../new-workout/new-workout/new-workout.component';
import { WorkoutService } from 'src/app/services/workout.service';
import { PageService } from 'src/app/services/page.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-main-display',
  templateUrl: './main-display.component.html',
  styleUrls: ['./main-display.component.css']
})
export class MainDisplayComponent {

  _workouts: Workout[] = [{
    title: '',
    page: {
      pageId: 0
    }
  }]

  newSet: Set[] = [{
    weightGoal: 0,
    repGoal: 0,
    weightActual: 0,
    repActual: 0,
    set: 0,
    workoutExercise: {
      workoutExerciseId: 0
    }
  }]

  pageNumber: number = 0
  pageNumberLoaded: boolean = false;
  
  constructor(private dialog: MatDialog, private workoutService: WorkoutService, private pageService: PageService, private cookieService: CookieService) {}

  ngOnInit() {
    this.workoutService.getWorkoutsByUserId(+this.cookieService.get('userId')).subscribe(workouts => {
      this._workouts = workouts;
      this.pageNumber = workouts.length;
      this.pageNumberLoaded = true;
    })
  }

  newWorkout() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.height = "20%";
    dialogConfig.width = "80%";
    let dialogRef = this.dialog.open(NewWorkoutComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(workout => {
      if(workout.title) {
        console.log(workout)
        this._workouts.concat = workout;
        console.log(this._workouts);
      }
    })
  }

  previous() {
    this.pageNumber = this.pageNumber - 1;
  }

  next() {
    this.pageNumber = this.pageNumber + 1;
  }

}
