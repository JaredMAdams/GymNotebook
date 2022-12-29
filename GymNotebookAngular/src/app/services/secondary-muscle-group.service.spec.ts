import { TestBed } from '@angular/core/testing';

import { SecondaryMuscleGroupService } from './secondary-muscle-group.service';

describe('SecondaryMuscleGroupService', () => {
  let service: SecondaryMuscleGroupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SecondaryMuscleGroupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
