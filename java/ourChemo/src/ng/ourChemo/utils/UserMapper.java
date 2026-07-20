package ng.ourChemo.utils;

import ng.ourChemo.data.models.User;
import ng.ourChemo.dtos.requests.RegisterUserRequest;

public class UserMapper {

    public static User mapper (RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUsername(registerUserRequest.getFullName());
        user.setPassword(registerUserRequest.getPassword());
        user.setFullName(registerUserRequest.getFullName());
        return user;
    }
}
