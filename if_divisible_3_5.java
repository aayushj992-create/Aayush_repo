import java.util.Scanner;

/**
 * Write a description of class if_divisible_3_5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class if_divisible_3_5
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a number");
        int num=scan.nextInt();
        if(num%3==0)
        { 
            if(num%5==0){
            System.out.println("It is divisible by both");
        }
            else
            {
                System.out.println("It is  divisible by 3 only");
            }
        }
        else if(num%5==0)
            {
                System.out.println("It is divisble by 5 only");
            }
            else{
            System.out.println("It is not divisible by both");
        }
    }
}