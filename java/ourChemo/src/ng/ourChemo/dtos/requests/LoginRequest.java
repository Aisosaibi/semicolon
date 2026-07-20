package ng.ourChemo.dtos.requests;

public class LoginRequest {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
}
