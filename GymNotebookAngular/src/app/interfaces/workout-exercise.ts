export interface WorkoutExercise {
    workoutExerciseId?: number;
    workout: {
        workoutId: number
    };
    exercise: {
        exerciseId: number
    };
    avgSpeed: number;
    calories: number;
    time: number;
    distance: number;
    notes: string;
}
