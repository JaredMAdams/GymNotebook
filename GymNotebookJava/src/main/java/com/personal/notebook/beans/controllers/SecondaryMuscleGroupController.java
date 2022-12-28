package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.SecondaryMuscleGroupService;
import com.personal.notebook.entities.SecondaryMuscleGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secondaries")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class SecondaryMuscleGroupController {

    private SecondaryMuscleGroupService secondaryMuscleGroupService;

    public SecondaryMuscleGroupController(SecondaryMuscleGroupService secondaryMuscleGroupService) {
        this.secondaryMuscleGroupService = secondaryMuscleGroupService;
    }

    @GetMapping(value = "/{secondaryMuscleGroupId}")
    public ResponseEntity<SecondaryMuscleGroup> getSecondaryMuscleGroupById(@PathVariable Integer secondaryMuscleGroupId) {
        Optional<SecondaryMuscleGroup> optionalSecondaryMuscleGroup = this.secondaryMuscleGroupService.readyBySecondaryMuscleGroupId(secondaryMuscleGroupId);
        try {
            optionalSecondaryMuscleGroup.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalSecondaryMuscleGroup.get());
    }

    @GetMapping
    public ResponseEntity<List<SecondaryMuscleGroup>> getAllSecondaryMuscleGroups(){
        return ResponseEntity.ok(this.secondaryMuscleGroupService.readAll());
    }

    @GetMapping(value = "/exercise/{exerciseId}")
    public ResponseEntity<List<SecondaryMuscleGroup>> getByExerciseId(@PathVariable Integer exerciseId) {
        return ResponseEntity.ok(this.secondaryMuscleGroupService.readByExerciseId(exerciseId));
    }

    @PostMapping
    public ResponseEntity<List<SecondaryMuscleGroup>> createMultipleSecondaryMuscleGroups(@RequestBody List<SecondaryMuscleGroup> secondaryMuscleGroups){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.secondaryMuscleGroupService.createMultipleSecondaryMuscleGroups(secondaryMuscleGroups));
    }

    @PutMapping
    public ResponseEntity<SecondaryMuscleGroup> updateSecondaryMuscleGroup(@RequestBody SecondaryMuscleGroup secondaryMuscleGroup) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.secondaryMuscleGroupService.createSecondaryMuscleGroup(secondaryMuscleGroup));
    }

    @DeleteMapping(value = "/{secondaryMuscleGroupId}")
    public void deleteSecondaryMuscleGroup(@PathVariable Integer secondaryMuscleGroupId) {
        this.secondaryMuscleGroupService.deleteSecondaryMuscleGroup(secondaryMuscleGroupId);
    }

    @DeleteMapping
    public void deleteMultipleSecondaryMuscleGroups(@RequestBody List<SecondaryMuscleGroup> secondaryMuscleGroupIds) {
        this.secondaryMuscleGroupService.deleteMultipleSecondaryMuscleGroups(secondaryMuscleGroupIds);
    }
}
