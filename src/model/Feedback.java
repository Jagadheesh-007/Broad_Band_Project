package model;
public class Feedback {
    public User user;
    public String comment;
    public Feedback(User user, String comment) {
        this.user = user;
        this.comment = comment;
    }
}
