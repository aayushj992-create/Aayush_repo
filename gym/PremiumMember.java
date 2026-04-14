package gym;


// Creating another subclass of GymMember and inheriting its attributes
public class PremiumMember extends GymMember {

    // Attributes
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    // Constructor
    public PremiumMember(int id, String name, String location, String phone,
                         String email, String gender, String DOB,
                         String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    // Accessor methods
    public double getPremiumCharge() {
        return this.premiumCharge;
    }

    public String getPersonalTrainer() {
        return this.personalTrainer;
    }

    public boolean getIsFullPayment() {
        return this.isFullPayment;
    }

    public double getPaidAmount() {
        return this.paidAmount;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    // Calculate remaining amount
    public String payDueAmount(double paidAmount) {
        if (isFullPayment) {
            return "Payment is already completed.";
        }
        if (paidAmount <= 0) {
            return "Invalid payment amount.";
        }
        this.paidAmount += paidAmount;
        if (this.paidAmount >= premiumCharge) {
            this.isFullPayment = true;
            this.paidAmount = premiumCharge; // Prevent overpayment
        }
        double remainingAmount = premiumCharge - this.paidAmount;
        return "Payment done successfully. Remaining Amount: " + remainingAmount;
    }

    // Calculate discount amount based on payment status
    public void calculateDiscount() {
        if (this.isFullPayment == true) {
            this.discountAmount = 0.1 * this.premiumCharge;
        } else {
            System.out.println("No Discount.");
        }
    }

    // Revert premium member status
    public void revertPremiumMember() {
        resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    // Implementing the abstract method markAttendance() to track attendance of the premium member
    @Override
    public void markAttendance() {
        if (this.activeStatus == true) {
            this.attendance++;
            this.loyaltyPoints += 10;
        } else {
            System.out.println("Membership is inactive.");
        }
    }

    // Display premium member details
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment Status: " + isFullPayment);
        System.out.println("Discount Amount: " + discountAmount);
    }
}