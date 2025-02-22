package controller;
import model.*;
import java.util.*;
public class SubscriptionController {
    public List<Subscription> subscriptions = new ArrayList<>();
    public void subscribe(User user, ServicePlan plan) {
        subscriptions.add(new Subscription(user, plan));
        System.out.println("Subscriped "+subscriptions.get(0).plan.planName+" Plan with Price "+ subscriptions.get(0).plan.price+" Successful!");
    }
}