
/**
 * Operators and Variables
 *
 * @author Aayush Joshi
 * @version v1.0
 */
public class Hellow
{
    int c=10;//instance variables
    static int d=10;//static variables
    public static void main(String[] args){
        int num3;//assigning the variables
        num3=10;//declaring the variables
        int h=1;
        //++h-->pre increment
        //h++->post increment operator
        System.out.println(h);//h=1
        System.out.println(++h);//h=2,++h=2
        System.out.println(h);//h=2
        System.out.println(h++);//h=3,h++=2
        System.out.println(h);//h=3
        int j=h++;
        int k=++h;
        System.out.println(j);
        
        int a=15;
        int b=3;
        int sum=a+b;
        int diff=a-b;
        int mul=a*b;
        int div=a/b;
        System.out.println("Sum is:"+sum);
        System.out.println("Difference is:"+diff);
        System.out.println("Multiplication is:"+mul);
        System.out.println("Division is:"+div);
        int num1=20;
        int num2=22;
        System.out.println(num1==num2);
         System.out.println(num1!=num2);
         System.out.println(num1>num2);
         System.out.println(num1<=num2);
         System.out.println(num1>=num2);
         System.out.println(num1<=num2);
        
        
    }
}