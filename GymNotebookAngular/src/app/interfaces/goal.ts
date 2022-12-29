export interface Goal {
    goalId?: number;
    reps: number;
    weight: number;
    user: {
        userId: number
    };
    exercise: {
        exerciseId: number
    };
}
