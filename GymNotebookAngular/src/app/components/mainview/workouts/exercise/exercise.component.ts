import { Component, Input } from '@angular/core';
import { WorkoutExercise } from 'src/app/interfaces/workout-exercise';
import { WorkoutExerciseService } from 'src/app/services/workout-exercise.service';

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.css']
})
export class ExerciseComponent {

  constructor(private workoutExerciseService: WorkoutExerciseService) {}

  @Input('workoutId') workoutId!: number;

  workoutExercises: WorkoutExercise[] = [{
    workout: {
      workoutId: 0
    },
    exercise: {
      exerciseId: 0,
      name: '',
      primaryMuscle: {
        muscleGroupId: 0
      },
      cardio: false,
      strength: false
    },
    avgSpeed: 0,
    calories: 0,
    time: 0,
    distance: 0,
    notes: ''
  }]

  workoutExercise: WorkoutExercise = {
    workout: {
      workoutId: 0
    },
    exercise: {
      exerciseId: 0,
      name: '',
      primaryMuscle: {
        muscleGroupId: 0
      },
      cardio: false,
      strength: false
    },
    avgSpeed: 0,
    calories: 0,
    time: 0,
    distance: 0,
    notes: ''
  }

  exercise: number = 0;

  ngOnChanges() {
    if(this.workoutId != undefined) {
      this.workoutExerciseService.getWorkoutExercisesByWorkout(this.workoutId!).subscribe(data => {
        this.workoutExercises = data;
        this.exercise = data.length;
        this.workoutExercise = this.workoutExercises.at(this.exercise - 1)!;
        console.log(this.workoutId);
        console.log(this.workoutExercises);
      })
    }
  }

  previous() {
    this.exercise = this.exercise - 1;
    this.workoutExercise = this.workoutExercises.at(this.exercise - 1)!;
  }

  next() {
    this.exercise = this.exercise + 1;
    this.workoutExercise = this.workoutExercises.at(this.exercise - 1)!;
  }
}
