package Week_9;


/**
 * Write a description of class contractEmployee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class contractEmployee extends employees
{
    int workingDays;
    public contractEmployee(int employeeId,String name,double basicSalary,int workingDays){
        super(employeeId,name,basicSalary);
        this.workingDays=workingDays;
    }
    double calculateTotalSalary(){
        double Total=basicSalary*workingDays;
        return Total;
    }
    public void totalSalary(){
        employeeInfo();
        System.out.println("His Total Salary is:"+calculateTotalSalary());
    }
}