import { Component, Input } from '@angular/core';
import { SetService } from 'src/app/services/set.service';
import { Set } from 'src/app/interfaces/set';

@Component({
  selector: 'app-sets',
  templateUrl: './sets.component.html',
  styleUrls: ['./sets.component.css']
})
export class SetsComponent {

  constructor(private setService: SetService) {}

  @Input('workoutExerciseId') workoutExerciseId!: number;

  displayedColumns: string[] = ['number', 'weight-goal', 'rep-goal', 'weight-actual', 'rep-actual']

  sets: Set[] = [{
    weightGoal: 0,
    repGoal: 0,
    weightActual: 0,
    repActual: 0,
    set: 0,
    workoutExercise: {
      workoutExerciseId: 0
    }
  }]

  setsLoaded: boolean = false;

  ngOnInit() {
    
  }

  ngOnChanges() {
    this.sets.length;
    if(this.workoutExerciseId != undefined){
      this.setsLoaded;
      this.setService.getSetsByWorkoutExerciseId(this.workoutExerciseId).subscribe(data => {
        console.log(this.workoutExerciseId);
        data.sort((a, b) => a.set - b.set);
        this.sets = data;
        console.log(this.sets);
        this.setsLoaded = true;
      })
    }
  }

}
