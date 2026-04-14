package gym;


// Creating a subclass of GymMember and inheriting its attributes
public class RegularMember extends GymMember {

    // Attributes
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    // Constructor
    public RegularMember(int id, String name, String location, String phone,
                         String email, String gender, String DOB,
                         String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.isEligibleForUpgrade = false;
        this.attendanceLimit = 30;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = "";
        this.referralSource = referralSource;
    }

    // Accessor methods
    public int getAttendanceLimit() {
        return this.attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade() {
        return this.isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return this.removalReason;
    }

    public String getReferralSource() {
        return this.referralSource;
    }

    public String getPlan() {
        return this.plan;
    }

    public double getPrice() {
        return this.price;
    }

    // Implementing the abstract method markAttendance() to track attendance of the regular member
    @Override
    public void markAttendance() {
        if (this.activeStatus == true) {
            this.attendance++;
            this.loyaltyPoints += 5;
        } else {
            System.out.println("Membership is inactive");
        }
    }

    // Retrieve the plan price according to name
    public double getPlanPrice(String plan) {
        switch (plan) {
            case "Basic":
                this.plan = "Basic";
                this.price = 6500;
                break;
            case "Standard":
                this.plan = "Standard";
                this.price = 12500;
                break;
            case "Deluxe":
                this.plan = "Deluxe";
                this.price = 18500;
                break;
            default:
                System.out.println("This plan is invalid");
                return -1; // Returns -1 if plan is invalid
        }
        return this.price;
    }

    // Upgrade plan if member is eligible
    public String upgradePlan(String plan) {
        if (this.attendance >= attendanceLimit) {
            this.isEligibleForUpgrade = true;
            System.out.println("The member is eligible for upgrade");
            if (this.plan.equals("Basic")) {
                this.plan = "Standard";
                this.price = 12500;
            } else if (this.plan.equals("Standard")) {
                this.plan = "Deluxe";
                this.price = 18500;
            } else {
                System.out.println("There is no change in plan and price.");
            }
        } else {
            System.out.println("Member is not eligible for upgrade");
        }
        return this.plan;
    }

    // Revert regular member status
    public String revertRegularMember(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = removalReason;
        this.referralSource = "";
        return removalReason;
    }

    // Display regular member details
    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}