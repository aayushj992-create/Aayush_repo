import java.util.Scanner;

/**
 * Write a description of class Grade_Evaluator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grade_Evaluator
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a number:");
        int a=scan.nextInt();
        String grade=(a>=40)?"PASS":"FAIL";
        System.out.println("You are "+grade);
        
    }
}