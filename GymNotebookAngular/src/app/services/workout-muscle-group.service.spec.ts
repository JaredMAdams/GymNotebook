import { TestBed } from '@angular/core/testing';

import { WorkoutMuscleGroupService } from './workout-muscle-group.service';

describe('WorkoutMuscleGroupService', () => {
  let service: WorkoutMuscleGroupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorkoutMuscleGroupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
