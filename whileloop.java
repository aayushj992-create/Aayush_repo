import java.util.Scanner;

/**
 * Write a description of class whileloop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class whileloop
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Do you want this operation to happen:");
        char option=scan.next().charAt(0);
        while(option=='y')
        {
            Scanner abc=new Scanner(System.in);
            System.out.println("Enter first number:");
            int first=abc.nextInt();
            System.out.println("Enter second number:");
            int second=abc.nextInt();
            System.out.println("if you want to add write a,write diff for d,write mul for m,write div for q");
            char operation=abc.next().charAt(0);
            if(operation=='a')
            {
                int sum=first+second;
                System.out.println("The sum is:"+sum);   
            }
            else if(operation=='d')
            {
                int diff=first-second;
                System.out.println("The sum is:"+diff);   
            }
            else if(operation=='m')
            {
                int mul=first*second;
                System.out.println("The sum is:"+mul);   
            }
            else if(operation=='q')
            {
                int div=first/second;
                System.out.println("The sum is:"+div);   
            }
            else
            {
                System.out.println("No operation");
            }
            break;
            }
            
        }
        }
