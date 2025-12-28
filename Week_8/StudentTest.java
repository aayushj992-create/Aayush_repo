package Week_8;


/**
 * Write a description of class StudentTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    public static void main(String[] args)
    {
        student st1= new student("Sandesh",101);
        //st1.setName("Sandesh");
        //String name=st1.getName();
        //System.out.println(name);
        System.out.println(st1.getName());
        System.out.println(st1.getId());//methods bata value access garda
        
        // set name uses to update value
        st1.setName("Sagar");
        st1.setId(101);
        System.out.println(st1.getName());
        System.out.println(st1.getId());
        st1.displayInfo();
        
        
    }
}