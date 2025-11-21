import java.util.Scanner;

/**
 *Math Operations
 *
 * @author (Aayush Joshi)
 * @version (a version number or a date)
 */
public class MathOperations
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter first number:");
        int a=scan.nextInt();
        System.out.println("Enter second number:");
        int b=scan.nextInt();
        int sum=a+b;
        int diff=a-b;
        int mul=a*b;
        int div=a/b;
        int pre_increment=++a;
        int post_increment=a++;
        int 
         greater=(a>b);
        
        
        
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(mul);
        System.out.println(div);
        
        
    }
}