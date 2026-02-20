package week_12;
import java.util.Scanner;


/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    public static void main (String[] args){
        String name;
        int age=0;
        double height=0;
        boolean Student;
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter your name:");
        name= scan.nextLine();
        System.out.println("Enter your age:");
        age=scan.nextInt();
        System.out.println("Enter your height:");
        height= scan.nextDouble();
        System.out.println("Are you a student(true or false)?");
        Student= scan.nextBoolean();
        System.out.println("My name is" + name + ",I am" + age + "years old" + height + "tall, it is, " + Student + "that i am a student");
    }
}
