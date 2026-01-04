package Week_9;


/**
 * Write a description of class payroll here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class payroll
{
    public static void main(String[] args){
        permanentEmployee p1=new permanentEmployee(101,"Ram",75000,5000,2000);
        contractEmployee c1=new contractEmployee(102,"Sita",85000,7);
        p1.totalSalary();
        c1.totalSalary();
    }
}