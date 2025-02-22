package model;
public class ServicePlan {
    public String planName;
    public double price;
    public int limitPerDay;
    public int duration;
    public ServicePlan(String planName, double price, int limitPerDay, int duration) {
        this.planName = planName;
        this.price = price;
        this.limitPerDay = limitPerDay;
        this.duration = duration;
    }
}