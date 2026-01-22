package week_12;
import java.util.ArrayList;


/**
 * Write a description of class arrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayListDemo
{
    public static void main(String[] args)
    {
       /*ArrayList numbers= new ArrayList();
       numbers.add(1);
       numbers.add(8);
       numbers.add("Ram");
       System.out.println(numbers);*/
       
       ArrayList<Integer> numbers= new ArrayList<Integer>();//Integer-wrapper class
       numbers.add(1);      //class ko naam capital.
       numbers.add(8);
       System.out.println(numbers);
       
       ArrayList<String> fruits=new ArrayList<String>();
       fruits.add("Apple");
       fruits.add("Papaya");
       fruits.add(0,"Orange");
       
       System.out.println(fruits);
       
       
       /*System.out.println(fruits.get(0));
       
       for(String element : fruits)
       {
           System.out.println(element);
        }*/
       // fruits.remove("Apple");//or index pass garne 
       // System.out.println(fruits);
       
       //set
       //fruits.set(0,"Mango");
       //System.out.println(fruits);
        
       //indexOf
       //System.out.println(fruits.indexOf("Papaya"));// method camel casing//if wrong input diyo bhane -1
       
       //contains
       //System.out.println(fruits.contains("Apple"));
       //System.out.println(fruits.contains("Mango"));
       
       
    
    }
}