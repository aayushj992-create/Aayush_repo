import java.util.Scanner;

/**
 * Write a description of class Odd_Even here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Odd_Even
{
    public static void main(String[] Args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a number");
        int num=scan.nextInt();
        if(num%2==0){
         System.out.println("It is even");   
        }
        else
        {
            System.out.println("It is odd");
        }
    }
}