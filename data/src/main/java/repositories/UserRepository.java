package repositories;

import mappers.UserDataUserMapper;
import model.User;
import model.UserData;

public class UserRepository implements IUserRepository {

    @Override
    public User getUser() {
        return UserDataUserMapper.
                getInstance()
                .apply(new UserData("qwerty", "qwerty"));
    }
}
