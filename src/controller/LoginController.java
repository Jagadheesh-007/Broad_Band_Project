package controller;
import model.User;
import java.util.*;
public class LoginController {
    private List<User> users;
    public LoginController(List<User> users) {
        this.users = users;
    }
    public String authenticate(String email, String password) {
        for (User user : users) {
            if (user.email.equals(email) && user.password.equals(password)) {
                return user.name;
            }
        }
        return null;
    }
}
