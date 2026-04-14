    package week_21;


/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee
{
    String name,salary,employeeType,benefit,department;
    public Employee(String name,String salary,String employeeType,String benefit,String department)
    {
        this.name=name;
        this.salary=salary;
        this.employeeType=employeeType;
        this.benefit=benefit;
        this.department=department;
    }
    public String toString()
    {
        return "Name: "+name+
               "\nSalary: "+salary+
               "\nType: "+employeeType+
               "\nBenefits: "+benefit+
               "\nDepartment: "+department;
    }
}