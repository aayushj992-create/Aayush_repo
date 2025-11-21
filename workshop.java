import java.util.Scanner;

/**
 * Write a description of class workshop here.
 *
 * @author Aayush Joshi
 * @version v1
 */
public class workshop
{
    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);//to take input 
        System.out.println("Enter First Number");
        int firstNum=scan.nextInt();//check entered num is int or not.
        System.out.println("My first Name is" +firstNum);
        System.out.println("Enter Second Number");
        double secondNum=scan.nextDouble();
        Scanner word=new Scanner(System.in);
        System.out.println("Ask his/her Number");
        String name=word.nextLine();
    }
}