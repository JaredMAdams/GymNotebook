package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuscleGroupRepo extends JpaRepository<MuscleGroup, Integer> {
}
