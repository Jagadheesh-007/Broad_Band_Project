package model;
public class Subscription {
    public User user;
    public ServicePlan plan;
    public Subscription(User user, ServicePlan plan) {
        this.user = user;
        this.plan = plan;
    }
}