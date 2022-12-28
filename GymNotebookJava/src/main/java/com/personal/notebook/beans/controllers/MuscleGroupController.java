package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.MuscleGroupService;
import com.personal.notebook.entities.MuscleGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/muscle-groups")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class MuscleGroupController {

    private MuscleGroupService muscleGroupService;

    public MuscleGroupController(MuscleGroupService muscleGroupService) {
        this.muscleGroupService = muscleGroupService;
    }

    @GetMapping(value = "/{muscleGroupId}")
    public ResponseEntity<MuscleGroup> getMuscleGroupById(@PathVariable Integer muscleGroupId) {
        Optional<MuscleGroup> optionalMuscleGroup = this.muscleGroupService.readyByMuscleGroupId(muscleGroupId);
        try {
            optionalMuscleGroup.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalMuscleGroup.get());
    }

    @GetMapping
    public ResponseEntity<List<MuscleGroup>> getAllMuscleGroups(){
        return ResponseEntity.ok(this.muscleGroupService.readAll());
    }

    @PostMapping
    public ResponseEntity<MuscleGroup> createMuscleGroup(@RequestBody MuscleGroup muscleGroup) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.muscleGroupService.createMuscleGroup(muscleGroup));
    }

    @PutMapping
    public ResponseEntity<MuscleGroup> updateMuscleGroup(@RequestBody MuscleGroup muscleGroup) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.muscleGroupService.createMuscleGroup(muscleGroup));
    }

    @DeleteMapping(value = "/{muscleGroupId}")
    public void deleteMuscleGroup(@PathVariable Integer muscleGroupId) {
        this.muscleGroupService.deleteMuscleGroup(muscleGroupId);
    }
}
