package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.SetRepo;
import com.personal.notebook.entities.Set;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetService {

    private final SetRepo setRepo;

    public SetService(SetRepo setRepo) {
        this.setRepo = setRepo;
    }

    public Optional<Set> readyBySetId(Integer setId) {
        return this.setRepo.findById(setId);
    }

    public List<Set> readAll() {
        return this.setRepo.findAll();
    }

    public Set createSet(Set set) {
        return this.setRepo.save(set);
    }

    public List<Set> createMultipleSets(List<Set> sets) {
        return this.setRepo.saveAll(sets);
    }

    public void deleteSet(Integer setId) {
        this.setRepo.deleteById(setId);
    }
}
