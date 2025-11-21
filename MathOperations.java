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
        //Arithematic
        int sum=a+b;
        int diff=a-b;
        int mul=a*b;
        int div=a/b;
        System.out.println("The sum is:"+sum);
        System.out.println("The difference is:"+diff);
        System.out.println("The Multiplication is:"+mul);
        System.out.println("The division is:"+div);
        //Urinary
        int pre_increment=++a;
        int post_increment=a++;
        System.out.println("The pre_increment is:"+pre_increment);
        System.out.println("The post_increment is:"+post_increment);
        //Assignment
        int c=10;
        System.out.println("The value of c is:"+c);
        //Relational
        boolean same=(a==b);
        System.out.println("a==b:"+same);
        boolean greater_than=(a>=b);
        System.out.println("a>=b:"+greater_than);
        boolean less=(a<=b);
        System.out.println("a<=b:"+less);
        boolean great=(a>b);
        System.out.println("a>b:"+less);
        boolean lesser=(a<b);
        System.out.println("a<b:"+lesser);
        boolean not=(a!=b);
        System.out.println("a!=b:"+not);
        //Logical
        boolean and=(a>b && a==b);
        System.out.println("a>b && a==b:"+and);
        boolean or=(a>b || a==b);
        System.out.println("a>b || a==b:"+or);
        //Ternary
        String greater=(a>b)?"a is greatest":"b is greatest";
        System.out.println(greater);
     
        
        
    }
}