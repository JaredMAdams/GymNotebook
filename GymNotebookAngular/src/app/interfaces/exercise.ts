export interface Exercise {
    exerciseId?: number;
    name: string;
    primaryMuscle: {
        muscleGroupId: number
    };
    cardio: boolean;
    strength: boolean;
}
