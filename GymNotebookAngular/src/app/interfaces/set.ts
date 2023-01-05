export interface Set {
    setId?: number;
    weightGoal: number;
    repGoal: number;
    weightActual: number;
    repActual: number;
    set: number;
    workoutExercise: {
        workoutExerciseId: number
    };
}