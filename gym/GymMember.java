package gym;


// Creating an abstract class
public abstract class GymMember {

    // Attributes
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    // Constructor
    public GymMember(int id, String name, String location, String phone,
                     String email, String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;
    }

    // Accessor methods
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGender() {
        return this.gender;
    }

    public String getDOB() {
        return this.DOB;
    }

    public String getMembershipStartDate() {
        return this.membershipStartDate;
    }

    public int getAttendance() {
        return this.attendance;
    }

    public double getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    public boolean getActiveStatus() {
        return this.activeStatus;
    }

    // Abstract method to track attendance of the member
    public abstract void markAttendance();

    // Method to activate membership
    public void activateMembership() {
        this.activeStatus = true;
    }

    // Method to deactivate membership
    public void deactivateMembership() {
        this.activeStatus = false;
    }

    // Method to reset member details
    public void resetMember() {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
    }

    // Display gym member details
    public void display() {
        System.out.println("Gym Member Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone Number: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
}