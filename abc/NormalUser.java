package abc;
import java.util.ArrayList;

public class NormalUser extends User {

    private ArrayList<GreenActivity> myActivities;
    private int activityCounter;

    public NormalUser(int id, String name, String email, String password) {
        super(id, name, email, password, "Student");
        this.myActivities    = new ArrayList<>();
        this.activityCounter = 1;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Normal User");
    }

    public void logActivity(String activityType, String date) {
        GreenActivity activity = new GreenActivity(activityCounter, activityType, date);
        myActivities.add(activity);
        activityCounter++;
        System.out.println("Activity logged! Points earned : " +
                GreenActivity.calculatePoints(activityType));
    }

    public void viewMyActivities() {
        if (myActivities.size() == 0) {
            System.out.println("No activities logged yet.");
            return;
        }
        System.out.println("==========================================");
        System.out.println("          YOUR GREEN ACTIVITIES           ");
        System.out.println("==========================================");
        for (int i = 0; i < myActivities.size(); i++) {
            System.out.println("Activity #" + (i + 1));
            System.out.println("  Type   : " + myActivities.get(i).getActivityType());
            System.out.println("  Date   : " + myActivities.get(i).getDate());
            System.out.println("  Points : " + myActivities.get(i).getPoints());
            System.out.println("------------------------------------------");
        }
        System.out.println("Total Points : " + getTotalPoints());
        System.out.println("==========================================");
    }

    public int getTotalPoints() {
        int total = 0;
        for (int i = 0; i < myActivities.size(); i++) {
            total += myActivities.get(i).getPoints();
        }
        return total;
    }

    public ArrayList<GreenActivity> getMyActivities() {
        return myActivities;
    }
}