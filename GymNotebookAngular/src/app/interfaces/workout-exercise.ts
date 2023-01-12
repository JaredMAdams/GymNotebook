export interface WorkoutExercise {
    workoutExerciseId?: number;
    workout: {
        workoutId: number;
    };
    exercise: {
        exerciseId?: number;
        name: string;
        primaryMuscle: {
            muscleGroupId: number
        };
        cardio: boolean;
        strength: boolean;
    };
    avgSpeed: number;
    calories: number;
    time: number;
    distance: number;
    notes: string;
}
