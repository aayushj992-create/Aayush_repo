import java.util.Scanner;

/**
 * Write a description of class Positive_negative_zero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Positive_negative_zero
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a number");
        int check=scan.nextInt();
        if(check>=1){
         System.out.println("It is positive");   
        }
        else if(check<0){
            System.out.println("It is negative");  
        }
        else if(check==0){
            System.out.println("It is zero");  
        }
        
    }
}