import java.util.Scanner;

/**
 * Write a description of class GPA here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GPA
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your GPA");
        float num=scan.nextFloat();
        if(num>=0.0 && num<=4.0){
            if(num<=4.0 && num>=3.61)
            {
                System.out.println("Your got A+");
            }
            else if(num<=3.60 && num>=3.00)
            {
                System.out.println("Your got A");
            }
            else if(num<=2.99 && num>=2.80)
            {
                System.out.println("Your got B+");
            }
            else if(num<=2.79 && num>=2.50)
            {
                System.out.println("Your got B");
            }
            else if(num<=2.49 && num>=2.0)
            {
                System.out.println("Your got C+");
            }
            else if(num<=1.99 && num>=1.2)
            {
                System.out.println("Your got C");
            }
            else 
            {
                System.out.println("Your are fail");
                
            }
           
        }
         else{
            System.out.println("Invalid");
        }
        
    }
}