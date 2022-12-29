export class UserModel {
    userId?: number;
    firstName: string;
    lastName: string;
    weight?: number;

    constructor(id:number, firstName: string, lastName: string, weight: number) {
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
    }
}
