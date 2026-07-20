package ng.ourChemo.utils;

import ng.ourChemo.data.models.User;
import ng.ourChemo.dtos.requests.LoginRequest;

public class LoginMapper {
    public static User mapper(LoginRequest loginRequest) {
        User user = new User();
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        return user;
    }
}
