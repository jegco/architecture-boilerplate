package mappers;

import model.User;
import model.UserData;

import java.util.function.Function;

public class UserDataUserMapper implements Function<UserData, User> {

    private static UserDataUserMapper instance;

    private UserDataUserMapper() {
    }

    public static UserDataUserMapper getInstance() {
        if (instance == null) {
            instance = new UserDataUserMapper();
        }
        return instance;
    }

    @Override
    public User apply(UserData userData) {
        return new User(userData.getUsername(), userData.getPassword());
    }
}
