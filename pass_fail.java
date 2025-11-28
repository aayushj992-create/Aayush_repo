import java.util.Scanner;

/**
 * Write a description of class pass_fail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pass_fail
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your marks");
        int marks=scan.nextInt();
        if(marks>40){
        System.out.println("You are Pass");    
        }
        else{
            System.out.println("You are fail");
        }
    }
}