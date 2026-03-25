package abc;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<User>          users      = new ArrayList<>();
    static ArrayList<GreenActivity> activities = new ArrayList<>();
    static int  userIDCounter = 1;
    static int  actIDCounter  = 1;
    static Scanner sc         = new Scanner(System.in);

    public static void main(String[] args) {

        
        users.add(new Admin(userIDCounter++, "Roger", "roger@campus.edu", "roger123"));

        System.out.println("==========================================");
        System.out.println("    WELCOME TO GREEN CAMPUS HELPER        ");
        System.out.println("    SDG Goal 13 - Climate Action           ");
        System.out.println("==========================================");

        
        System.out.println("\n--- Activity Points Table ---");
        System.out.println("Cycling     : " + GreenActivity.calculatePoints("Cycling")     + " pts");
        System.out.println("Electricity : " + GreenActivity.calculatePoints("Electricity") + " pts");
        System.out.println("Recycling   : " + GreenActivity.calculatePoints("Recycling")   + " pts");

        int choice = 0;

        while (choice != 3) {
            System.out.println("\n==========================================");
            System.out.println("               MAIN MENU                  ");
            System.out.println("==========================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (choice == 1) {
                register();
            } else if (choice == 2) {
                login();
            } else if (choice == 3) {
                System.out.println("\n==========================================");
                System.out.println("  Thank you for using Green Campus Helper  ");
                System.out.println("  Together we act for Climate Action!       ");
                System.out.println("==========================================");
            } else {
                System.out.println("Invalid choice. Please enter 1, 2 or 3.");
            }
        }

        sc.close();
    }

    
    static void register() {
        System.out.println("\n--- Register New Account ---");
        System.out.print("Enter your name     : "); String name  = sc.nextLine();
        System.out.print("Enter your email    : "); String email = sc.nextLine();
        System.out.print("Enter your password : "); String pass  = sc.nextLine();

        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                System.out.println("Email already registered. Please login.");
                return;
            }
        }

        System.out.println("Select role:");
        System.out.println("1. Student");
        System.out.println("2. Admin");
        System.out.print("Enter choice: ");

        int roleChoice = 0;
        try {
            roleChoice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Registering as Student.");
            roleChoice = 1;
        }

        if (roleChoice == 2) {
            users.add(new Admin(userIDCounter++, name, email, pass));
            System.out.println("Admin account created for " + name + "!");
        } 
        else {
            users.add(new NormalUser(userIDCounter++, name, email, pass));
            System.out.println("Student account created for " + name + "!");
        }
    }

        static void login() {
        System.out.println("\n--- Login ---");
        System.out.print("Enter email    : "); String email = sc.nextLine().trim();
        System.out.print("Enter password : "); String pass  = sc.nextLine().trim();

        User current = null;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).login(email, pass)) {
                current = users.get(i);
                break;
            }
        }

        if (current == null) {
            System.out.println("Login failed. Wrong email or password.");
            return;
        }

        System.out.println("Login successful! Welcome " + current.getName());
        current.displayRole();   

        if (current.getRole().equals("Admin")) {
            adminMenu((Admin) current);
        } else {
            userMenu((NormalUser) current);
        }
    }

    
    static void userMenu(NormalUser user) {
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n==========================================");
            System.out.println("             STUDENT MENU                 ");
            System.out.println("  Logged in as : " + user.getName());
            System.out.println("==========================================");
            System.out.println("1. Log Green Activity");
            System.out.println("2. View My Activities");
            System.out.println("3. View My Total Points");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (choice == 1) {

                System.out.println("\n--- Select Activity Type ---");
                System.out.println("1. Cycling     (10 pts)");
                System.out.println("2. Electricity (15 pts)");
                System.out.println("3. Recycling   (12 pts)");
                System.out.print("Enter choice: ");

                int actChoice = 0;
                try {
                    actChoice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    continue;
                }

                String type = "";
                if(actChoice == 1) 
                type = "Cycling";
                else if (actChoice == 2) 
                type = "Electricity";
                else if (actChoice == 3) 
                type = "Recycling";
                else 
                { 
                System.out.println("Invalid activity choice."); 
                continue; 
                }

                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                user.logActivity(type, date);

                ArrayList<GreenActivity> userActs = user.getMyActivities();
                activities.add(userActs.get(userActs.size() - 1));

                } 
                else if (choice == 2) {
                user.viewMyActivities();

                } 
                else if (choice == 3) {
                System.out.println("Your total points : " + user.getTotalPoints());

                } 
                else if (choice == 4) {
                user.logout();

                } 
                else {
                System.out.println("Invalid choice.");
            }
        }
    }

    
    static void adminMenu(Admin admin) {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n==========================================");
            System.out.println("              ADMIN DASHBOARD             ");
            System.out.println("  Logged in as : " + admin.getName());
            System.out.println("==========================================");
            System.out.println("1. View All Activities");
            System.out.println("2. View All Users");
            System.out.println("3. Generate Report");
            System.out.println("4. View Activity Summary");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (choice == 1) {
                admin.viewAllActivities(activities);
            } 
            else if (choice == 2) {
                admin.viewAllUsers(users);

            } 
            else if (choice == 3) {
    
                Reportable r = (Reportable) admin;
                r.generateReport();

            } 
            else if (choice == 4) {
                admin.generateReport(activities);   

            } 
            else if (choice == 5) {
                admin.logout();

            } 
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}