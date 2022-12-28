package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.WorkoutMuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutMuscleGroupRepo extends JpaRepository<WorkoutMuscleGroup, Integer> {

    List<WorkoutMuscleGroup> findByWorkout_WorkoutId(Integer workoutId);

//    List<WorkoutMuscleGroup> findByMuscleGroup_MuscleGroupId(Integer muscleGroupId);

    @Query(value = "SELECT * FROM workout_muscle_groups wmg JOIN workouts w ON wmg.workout_workout_id = w.workout_id JOIN pages p ON w.page_id = p.page_id JOIN notebooks n ON p.notebook_id = n.notebook_id JOIN users u ON n.user_id = u.user_id WHERE wmg.muscle_group_muscle_group_id = :muscleGroupId AND u.user_id = :userId", nativeQuery = true)
    List<WorkoutMuscleGroup> findByUserMuscleGroup(@Param("muscleGroupId") Integer muscleGroupId, @Param("userId") Integer userId);
}
