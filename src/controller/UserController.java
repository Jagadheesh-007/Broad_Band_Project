package controller;
import model.User;
import java.util.*;
public class UserController {
    public List<User> users = new ArrayList<>();
    public void registerUser(String name, String email, String password) {
        for (User user : users) {
            if (user.email.equals(email)) {
                System.out.println("Error: Email already exists!");
                return;
            }
        }
        if (password.length() < 8) {
            System.out.println("Error: Password must be at least 8 characters long.");
            return;
            
        }
        users.add(new User(name, email, password));
        System.out.println("User Registered Successfully!");
    }
}
