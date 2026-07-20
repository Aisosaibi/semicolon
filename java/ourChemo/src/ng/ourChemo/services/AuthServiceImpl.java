//package ng.ourChemo.services;
//
//import ng.ourChemo.data.models.User;
//import ng.ourChemo.data.repositories.UserRepository;
//import ng.ourChemo.data.repositories.UserRepositoryImpl;
//
//public class AuthServiceImpl implements  AuthService {
//
//    private final UserRepository userRepository = new UserRepositoryImpl();
//
//    @Override
//    public String login(String username, String password) {
//        return "";
//    }
//
//    @Override
//    public String logout(String username) {
//        return "";
//    }
//
//    @Override
//    public String registerChemist(String username, String password, String fullName) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setFullName(fullName);
//        userRepository.save(user);
//        System.out.println("User " + username + " has been registered successfully");
//        return "";
//    }
//}



package ng.ourChemo.services;

import ng.ourChemo.data.models.User;
import ng.ourChemo.data.repositories.UserRepository;
import ng.ourChemo.dtos.requests.LoginRequest;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.utils.UserMapper;

public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public String Login(LoginRequest loginRequest) {
//        loginRequest.setUsername(loginRequest.getUsername().toLowerCase());
//        User user = userRepository.findByUsername(loginRequest.getUsername());
//        if(user == null){return "user not found";}
//
//
//        if (user.getPassword().equals(loginRequest.getPassword())) {
//            user.setLoggedIn(true);
//            userRepository.save(user);
//        }
//        return null;
//        return "";
//    }

    @Override
    public String Login(LoginRequest loginRequest) {
        loginRequest.setUsername(loginRequest.getUsername().toLowerCase());
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if(user == null){return "user not found";}


        if (user.getPassword().equals(loginRequest.getPassword())) {
            user.setLoggedIn(true);
            userRepository.save(user);
        }
        return null;
    }


    @Override
    public String Logout(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null ){
            return "user not found";
        }

        user.setLoggedIn(false);
        userRepository.save(user);

        return "logged in ";
    }

    @Override
    public String Register(String username, String password, String fullName) {
        return "";
    }

//    @Override
//    public String registerChemist(RegisterUserRequest registerUserRequest) {
//        User user = Usermapper.mapper(registerUserRequest);
//        userRepository.save(user);
//        return "Save Success";
//    }

    @Override
    public String registerChemist(RegisterUserRequest registerUserRequest) {
        registerUserRequest.setUserName(registerUserRequest.getUserName().toLowerCase());
        User savedUser = userRepository.findByUsername(registerUserRequest.getUserName());
        if(savedUser != null){
            throw  new RuntimeException("Username already exists");
        }
        User user = UserMapper.mapper(registerUserRequest);
        userRepository.save(user);
        return "Save Success";
    }
}