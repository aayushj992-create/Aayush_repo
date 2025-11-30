import java.util.Scanner;

/**
 * Write a description of class CinemaTicket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CinemaTicket
{
    public static void main(String[] args){
        float Child=150;
        float Adult=250;
        float Senior=200;
        System.out.println("Base fare by age");
        System.out.println("Child:"+Child);
        System.out.println("Adult:"+Adult);
        System.out.println("Senior:"+Senior);
        float Hindi_Movie=50;
        float English_Movie=100;
        System.out.println("Surcharge for Movie Language"); 
        System.out.println("Hindi Movie:"+Hindi_Movie);
        System.out.println("English Movie:"+English_Movie);
        System.out.println("Surcharge for Movie Language"); 
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Age:");
        int age=scan.nextInt();
        System.out.println("Enter Movie Language.Write H for Hindi and E for english:");
        char movie=scan.next().charAt(0);
        System.out.println("Enter if he/she is a Student or not.Type Y for Yes and N for No:");
        char student=scan.next().charAt(0);
        System.out.println("Enter if it is a Festival.Type Y for Yes and N for No:");
        char festival=scan.next().charAt(0);
        if(age<18 && movie=='H' && student=='Y' && festival=='N')
        {
            float cost=200*0.2f;
            float total_cost=(Child+Hindi_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age<18 && movie=='E' && student=='Y' && festival=='N')
        {
            float cost=(Child+English_Movie)*0.2f;
            float total_cost=(Child+English_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age<18 && movie=='H' && student=='Y' && festival=='Y')
        {
            float cost=(Child+Hindi_Movie)*0.35f;
            float total_cost=(Child+Hindi_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age<18 && movie=='E' && student=='Y' && festival=='Y')
        {
            float cost=(Child+English_Movie)*0.35f;
            float total_cost=(Child+English_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age>18 && age<=70 && movie=='H' && student=='Y' && festival=='N')
        {
            float cost=(Adult+Hindi_Movie)*0.2f;
            float total_cost=(Adult+Hindi_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age<18 && age<=70 && movie=='E' && student=='Y' && festival=='N')
        {
            float cost=(Adult+English_Movie)*0.2f;
            float total_cost=(Adult+English_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age<18 && age<=70 && movie=='H' && student=='Y' && festival=='Y')
        {
            float cost=(Adult+Hindi_Movie)*0.35f;
            float total_cost=(Adult+Hindi_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age<18 && age<=70 && movie=='E' && student=='Y' && festival=='Y')
        {
            float cost=(Adult+English_Movie)*0.35f;
            float total_cost=(Adult+English_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age>70 && movie=='H' && student=='N' && festival=='N')
        {
            float cost=(Senior+Hindi_Movie)*0.2f;
            float total_cost=(Senior+Hindi_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age>70 && movie=='E' && student=='N' && festival=='N')
        {
            float cost=(Senior+English_Movie)*0.2f;
            float total_cost=(Senior+English_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age>70 && movie=='H' && student=='N' && festival=='Y')
        {
            float cost=(Senior+Hindi_Movie)*0.35f;
            float total_cost=(Senior+Hindi_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }
        else if(age>70 && movie=='E' && student=='N' && festival=='Y')
        {
            float cost=(Senior+English_Movie)*0.35f;
            float total_cost=(Senior+English_Movie)-cost;
            System.out.println("The total cost is"+total_cost);
        }   
}
}