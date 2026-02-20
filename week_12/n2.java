package week_12;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Write a description of class n2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class n2
{
    public static void main(String[] args)
    {
        ArrayList<String> names=new ArrayList<String>();
        names.add("Haku");
        names.add("Tako");
        names.add("Maharjan");
        names.add("Ram");
        names.add("Shyam");
        names.add("Hari");
        for(String name:names)
        {
            System.out.println(name);
        }
        ArrayList<Integer> numbers=new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        for(Integer number:numbers)
        {
            System.out.println(number);
        }
        Iterator<String> it=names.iterator();
        while(it.hasNext())
        {
            String name=it.next();
            System.out.println(name);
        }
        
        Iterator<Integer> itr=numbers.iterator();
        while(itr.hasNext())
        {
            Integer number=itr.next();
            System.out.println(number);
        }
        names.remove(2);
        System.out.println(names.size());
        
        System.out.println(names.get(3));
        System.out.println(names.get(4));
        
        
        
        
        
        names.clear();
        
    }
}