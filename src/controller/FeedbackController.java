package controller;
import model.*;
import java.util.*;
public class FeedbackController {
    public List<Feedback> feedbackList = new ArrayList<>();
    public void submitFeedback(User user, String comment) {
        feedbackList.add(new Feedback(user, comment));
        System.out.println("Feedback Submitted. Thank you!");
    }
}