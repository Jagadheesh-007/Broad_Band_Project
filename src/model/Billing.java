package model;
public class Billing {
    public User user;
    public ServicePlan plan;
    public Billing(User user, ServicePlan plan) {
        this.user = user;
        this.plan = plan;
    }
}