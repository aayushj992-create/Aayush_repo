import java.util.Scanner;

/**
 * Write a description of class Drive here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Drive
{
    public static void main(String[] args){
        Scanner age=new Scanner(System.in);
        System.out.println("Enter age");
        int a=age.nextInt();
        String CanDrive=(a>=18)?"allowed to drive":"Cannot Drive";
        System.out.println(CanDrive);
    }
}