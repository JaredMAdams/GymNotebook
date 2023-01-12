import { Component, Input } from '@angular/core';
import { Workout } from 'src/app/interfaces/workout';
import { WorkoutExercise } from 'src/app/interfaces/workout-exercise';
import { WorkoutExerciseService } from 'src/app/services/workout-exercise.service';
import { WorkoutService } from 'src/app/services/workout.service';

@Component({
  selector: 'app-workout-display',
  templateUrl: './workout-display.component.html',
  styleUrls: ['./workout-display.component.css']
})
export class WorkoutDisplayComponent {

  constructor(private workoutExerciseService: WorkoutExerciseService) {}

  @Input('pageNumber') pageNumber!: number;
  @Input('workouts') workouts!: Workout[];

  workout: Workout = {
    title: '',
    page: {
      pageId: 0
    }
  } ;

  

  ngOnInit() {
  }

  ngOnChanges() {
    if(this.pageNumber != 0) {
      this.workout = this.workouts.at(this.pageNumber - 1)!;
    }
  }

}
