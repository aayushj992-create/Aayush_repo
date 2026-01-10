package week_10;


/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class hospitalapp
{
    public static void main(String[] args)
    {
        Person p1=new Person(101,"Sandesh");
        System.out.println(p1);  
        doctor d1=new doctor(1,"Suraj","Opthamologist",5000);
        nurse n1=new nurse(2,"Sita","Morning",1000);
        System.out.println(d1.calculateSalary());
        System.out.println(d1.calculateSalary(2));
        d1.displayDoctorDetails();
        n1.calculateSalary();
        System.out.println(n1);
    
    }
}