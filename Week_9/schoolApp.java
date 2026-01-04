package Week_9;


/**
 * Write a description of class schoolApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class schoolApp
{
    public static void main(String[] args){
        teacher t1=new teacher(2,"Raj",75000,"Math",5000);
        staff s1=new staff(101,"Ramu",50000,8,0.15);
        t1.calculateAnnualSalary();
        s1.calculateSalary();
    }
}