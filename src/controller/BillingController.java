package controller;
import model.*;
public class BillingController {
    public void generateBill(User user, ServicePlan s) {
        System.out.println("-----------------------------Billing-------------------------------------");
        System.out.println("| Name      : "+user.name);
        System.out.println("| Email     : "+user.email);
        System.out.println("---------------------Subscription_Details-------------------------------|");
        System.out.println("| Plan_Name : "+s.planName);
        System.out.println("| Price     : "+s.price);
        System.out.println("| Duration  : "+s.duration);
        System.out.println("-------------------------------------------------------------------------");
    }
}
