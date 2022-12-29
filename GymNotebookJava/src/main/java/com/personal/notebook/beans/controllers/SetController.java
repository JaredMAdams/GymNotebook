package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.SetService;
import com.personal.notebook.entities.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sets")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class SetController {

    private SetService setService;

    public SetController(SetService setService) {
        this.setService = setService;
    }

    @GetMapping(value = "/{setId}")
    public ResponseEntity<Set> getSetById(@PathVariable Integer setId) {
        Optional<Set> optionalSet = this.setService.readyBySetId(setId);
        try {
            optionalSet.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalSet.get());
    }

    @GetMapping
    public ResponseEntity<List<Set>> getAllSets(){
        return ResponseEntity.ok(this.setService.readAll());
    }

    @PostMapping
    public ResponseEntity<Set> createSet(@RequestBody Set set) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.setService.createSet(set));
    }

    @PostMapping(value = "/multiple")
    public ResponseEntity<List<Set>> createMultipleSets(@RequestBody List<Set> sets) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.setService.createMultipleSets(sets));
    }

    @PutMapping
    public ResponseEntity<Set> updateSet(@RequestBody Set set) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.setService.createSet(set));
    }

    @DeleteMapping(value = "/{setId}")
    public void deleteSet(@PathVariable Integer setId) {
        this.setService.deleteSet(setId);
    }
}
