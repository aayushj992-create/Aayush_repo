import java.util.Scanner;

/**
 * Write a description of class integer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class integer
{
    public static void main(String[] args)
    {
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter a positive integer number:");
    int num=scan.nextInt();
    int sum=0;
    while(num!=0)
    {
        int rem=num%10;
        sum=sum*10+rem;
        num=num/10;
}
System.out.println(sum);
}
}

