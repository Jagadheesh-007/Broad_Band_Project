package view;
import controller.*;
import model.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        LoginController loginController = new LoginController(userController.users);
        BillingController billingController = new BillingController();
        FeedbackController feedbackController = new FeedbackController();
        List<ServicePlan> plans = Arrays.asList(
            new ServicePlan("Basic", 499, 2, 30),
            new ServicePlan("Standard", 799, 4, 30),
            new ServicePlan("Premium", 999, 6, 30)
        );
        User currentUser = null;
        ServicePlan selectedPlan = null;
        while (true) {
            System.out.println("\n==================== Broadband Service System ======================");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. View Service Plans");
            System.out.println("4. Subscribe to a Plan");
            System.out.println("5. View Billing Details");
            System.out.println("6. Give Feedback");
            System.out.println("7. Display Feedbacks");
            System.out.println("8. Logout");
            System.out.println("9. Exit");
            System.out.println("\n====================================================================\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    userController.registerUser(name, email, password);
                    break;
                case 2:
                    System.out.print("Enter email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    String loginName = loginController.authenticate(loginEmail, loginPassword);
                    if (loginName!=null) {
                        System.out.println("Login Successful!");
                        currentUser = new User(loginName, loginEmail, loginPassword);
                    } else {
                        System.out.println("Invalid Password or email_id .............");
                    }
                    break;
                case 3:
                    for (ServicePlan plan : plans) {
                        System.out.println(plan.planName + " - ₹" + plan.price + " - " + plan.limitPerDay + "GB/day - " + plan.duration + " days");
                    }
                    break;
                case 4:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    if(selectedPlan!=null)
                    {
                        System.out.println("Plan in activation .............");
                        break;
                    }
                    System.out.println("Choose a plan:");
                    for (int i = 0; i < plans.size(); i++) {
                        System.out.println((i + 1) + ". " + plans.get(i).planName);
                    }
                    int planChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (planChoice > 0 && planChoice <= plans.size()) {
                        selectedPlan = plans.get(planChoice - 1);
                        System.out.println("Subscribed successfully to " + selectedPlan.planName);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 5:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    if(selectedPlan == null)
                    {
                        System.out.println("Subscribe the plan first...");
                        break;
                    }
                    billingController.generateBill(currentUser,selectedPlan);
                    break;
                case 6:
                    String feedback = scanner.nextLine();
                    feedbackController.submitFeedback(currentUser,feedback);
                    break;
                case 7:
                    System.out.println("Give your feedback here....");
                    feedbackController.getFeedback();
                    break;
                case 8:
                    System.out.println("Logged out "+currentUser.name+"................");
                    currentUser = null;
                    selectedPlan = null;
                    break;
                case 9:
                    System.out.println("Exiting...\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}