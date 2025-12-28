package Week_8;


/**
 * Write a description of class Salary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Salary
{
   public static void main(String[] args){
       Employee e1=new Employee(99999);
       e1.getSalary();
       System.out.println("Your bonus salary is"+e1.calculateGrossSalary());
   }
}