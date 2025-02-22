package controller;
import model.*;
public class BillingController {
    public void generateBill(User user, ServicePlan s) {
        System.out.println("Billing: " + user.name +" "+user.email+ " ownes $" + s.price);
    }
}
