package Week_9;


/**
 * Write a description of class permanentEmployee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class permanentEmployee extends employees
{
   double rentAllowance; 
   double dearnessAllowance;
   public permanentEmployee(int employeeId,String name,double basicSalary,double rentAllowance,double dearnessAllowance){
       super(employeeId,name,basicSalary);
       this.rentAllowance=rentAllowance;
       this.dearnessAllowance=dearnessAllowance;
   }
   double calculateTotalSalary(){
       double total=basicSalary +rentAllowance+dearnessAllowance+calculateBonus();
       return total;
   }
   public void totalSalary(){
       employeeInfo();
       System.out.println("His Total Salary is:"+calculateTotalSalary());
   }
}