package controller;
import model.*;
import java.util.*;
public class FeedbackController {
    public List<Feedback> feedbackList = new ArrayList<>();
    public void submitFeedback(User user, String comment) {
        feedbackList.add(new Feedback(user, comment));
        System.out.println("Feedback Submitted. Thank you!");
    }
    public void getFeedback()
    {
        if(feedbackList.isEmpty())
        {
            System.out.println("No Feedbacks.....");
            return;
        }
        System.out.println("---------------------------Feedback Lists----------------------");
        for(Feedback list : feedbackList)
        {
            System.out.println(list.user.name);
            System.out.println(list.comment);
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------");
    }
}