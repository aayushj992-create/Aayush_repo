package week_10;


/**
 * Write a description of class doctor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class doctor extends Person
{
    private String specialization;
    private double consultationFee;
    
    public doctor(int id, String name,String specialization,double consultationFee)
    {
        super(id,name);
        this.specialization=specialization;
        this.consultationFee=consultationFee;
    }
    
    @Override//Polymorphism run time 
    public double calculateSalary()
    {
       double baseFee=super.calculateSalary(); 
       double normalPayment=baseFee + (this.consultationFee * 30);
       return normalPayment;
    }
    //method overloading 
    public double calculateSalary(int emergencyCase)
    {
       double normalPay=this.calculateSalary();
       double perEmergencyCharge=1000;
       double emergencyBonus=emergencyCase * perEmergencyCharge;
       return normalPay=emergencyBonus;
    }
    public void displayDoctorDetails()
    {
        super.displayDetails();
        System.out.println("Specialization"+ this.specialization);
        System.out.println("Consultation Fee"+ this.consultationFee);
        System.out.println("Salary"+ this.calculateSalary());
    }
  
    public void setSpecialization(String specialization)
    {
        this.specialization=specialization;
    }
    public String getSpecialization()
    {
        return this.specialization;
    }
    public void setconsultationFee(double consultationFee)
    {
        this.consultationFee=consultationFee;
    }
    public double getconsultationFee()
    {
        return this.consultationFee;
    }
      @Override
    public String toString(){
        return super.toString()+",specialization:"+this.specialization;
    }
}