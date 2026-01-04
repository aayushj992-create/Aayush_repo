package Week_9;


/**
 * Write a description of class staff here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class staff extends person
{
    int workingHours;
    double ratePerHour;
    public staff(int id,String name,double basicSalary,int workingHours,double ratePerHour){
        super(id,name,basicSalary);
        this.workingHours=workingHours;
        this.ratePerHour=ratePerHour;
    }
    double calculateSalary(){
        double salary=super.calculateAnnualSalary()+this.workingHours * this.ratePerHour;
        displayInfo();
        System.out.println("The Total Salary is:"+salary);
        return salary;
    }
}