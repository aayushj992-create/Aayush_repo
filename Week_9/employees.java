package Week_9;


/**
 * Write a description of class employees here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class employees
{
    int employeeId;
    String name;
    double basicSalary;
    public employees(int employeeId,String name,double basicSalary){
        this.employeeId=employeeId;
        this.name=name;
        this.basicSalary=basicSalary;
    }
    double calculateBonus(){
        return this.basicSalary*0.1;
    }
    void displayEmployee(){
        System.out.println(employeeId);
        System.out.println(name);
        System.out.println(basicSalary);
    }
    public void employeeInfo(){
        System.out.println("The employeeId is:"+employeeId);
        System.out.println("Name:"+name);
        System.out.println("Basic Salary is:"+basicSalary);
    }
}