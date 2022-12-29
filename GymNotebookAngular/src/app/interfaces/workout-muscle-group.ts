export interface WorkoutMuscleGroup {
    workoutMuscleGroupId?: number;
    workout: {
        workoutId: number
    };
    muscleGroup: {
        muscleGroupId: number
    };
}
