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

  workoutExercises: WorkoutExercise[] = [{
    workout: {
      workoutId: 0
    },
    exercise: {
      exerciseId: 0
    },
    avgSpeed: 0,
    calories: 0,
    time: 0,
    distance: 0,
    notes: ''
  }]

  ngOnInit() {
  }

  ngOnChanges() {
    if(this.pageNumber != 0) {
      this.workout = this.workouts.at(this.pageNumber - 1)!;
      this.workoutExerciseService.getWorkoutExercisesByWorkout(this.workout.workoutId!).subscribe(data => {
        this.workoutExercises = data;
        console.log(this.workoutExercises)
      })
    }
  }

}
