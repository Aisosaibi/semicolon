package ng.ourChemo.services;

import ng.ourChemo.data.models.User;
import ng.ourChemo.dtos.requests.LoginRequest;
import ng.ourChemo.dtos.requests.RegisterUserRequest;

public interface AuthService {
    String Login(LoginRequest loginRequest);
    String Logout(String username);
    String registerChemist(RegisterUserRequest registerUserRequest);
}