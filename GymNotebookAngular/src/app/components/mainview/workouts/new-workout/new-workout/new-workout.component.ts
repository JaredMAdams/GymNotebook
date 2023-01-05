import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Workout } from 'src/app/interfaces/workout';
import { WorkoutService } from 'src/app/services/workout.service';

@Component({
  selector: 'app-new-workout',
  templateUrl: './new-workout.component.html',
  styleUrls: ['./new-workout.component.css']
})
export class NewWorkoutComponent {

  constructor(private dialogRef: MatDialogRef<NewWorkoutComponent>, private workoutService: WorkoutService) {}

  newWorkout: Workout = {
    title: '',
    page: {
      pageId: 1
    }
  }

  onClose() {
    this.newWorkout.title = ''
    this.dialogRef.close(this.newWorkout);
  }

  titleClear() {
    this.newWorkout.title = '';
  }

  onSubmit() {
    // this.workoutService.postWorkout(this.newWorkout).subscribe()
    this.dialogRef.close(this.newWorkout)
  }
}