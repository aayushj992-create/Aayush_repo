import java.util.Scanner;

/**
 * Write a description of class Greatest_Number here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Greatest_Number
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter First Number:");
        int num1=scan.nextInt();
        System.out.println("The First Number is:"+num1);
        System.out.println("Enter Second  Number:");
        int num2=scan.nextInt();
        System.out.println("The Second Number is:"+num2);
        System.out.println("Enter Third Number:");
        int num3=scan.nextInt();
        System.out.println("The Third Number is:"+num3);       
String Largest=(num1>num2 && num1>num3)?"num1 is the biggest":(num2>num1 && num2>num3)?"num2 is the biggest":"num3 is the biggest";
System.out.println(Largest);
}
}

