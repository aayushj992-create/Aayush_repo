package Week_8;


/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee
{
  private double basicSalary;
  public Employee(double basicSalary)
  {
      this.basicSalary=basicSalary;
  }
  public void setSalary(double salary)
  {
      this.basicSalary=salary;
  }
  public double getSalary()
  {
    return this.basicSalary;
  }
  public double calculateGrossSalary()
  {
    double fin=getSalary();
    double cal=fin+fin*0.20;
    return cal;
    }
}