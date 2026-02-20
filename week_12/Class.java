package week_12;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Write a description of class Class here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Class
{
    public static void main(String[] args)
    {
        ArrayList<Student> std=new ArrayList<>();
        std.add(new Student("Ayush",9876543210L,"L1N1"));
        std.add(new Student("Rahul",9876543211L,"L1M1"));
        std.add(new Student("Gaurav",9876543212L,"L1N2"));
        for(Student studs:std)
        {
            System.out.println(studs+"\n");
        }
        
        for(int i=0;i<std.size();i++)
        {
            if(std.get(i).getName().equals("Ayush"))
            {
                std.add(i,new Student("Aavaya",98765433L,"L1C1"));
                break;
            }
        }
        for(Student studs:std)
        {
            System.out.println(studs);
        }
        
        Iterator<Student> it=std.iterator();
        while(it.hasNext())
        {
            if(it.equals("Gaurav")){
                
            }
        }
    }
    
}