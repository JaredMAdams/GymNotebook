import { UserModel } from './user-model';

describe('UserModel', () => {
  it('should create an instance', () => {
    expect(new UserModel(1, "Jared", "Adams", 165)).toBeTruthy();
  });
});
