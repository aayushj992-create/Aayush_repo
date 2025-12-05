import java.util.Scanner;

/**
 * Write a description of class multiplication here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class multiplication
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number");
        int num=scan.nextInt();
        for(int i=1;i<=10;i++)
        {
        int mul=num*i;
        System.out.println(num+"*"+i+"="+mul);
        }
    }
}