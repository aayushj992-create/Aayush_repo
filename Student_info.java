import java.util.Scanner;

/**
 * Write a description of class Student_info here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student_info
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your name");
        String Name=scan.nextLine();
        System.out.println("Your name is:"+Name);
        Scanner num=new Scanner(System.in);
        System.out.println("Enter Age:");
        int age=num.nextInt();
        System.out.println("Your age is:"+age);
        System.out.println("Enter GPA:");
        double GPA=num.nextDouble();
        System.out.println("Your GPA is:"+GPA);
    }
}