import java.util.Scanner;

/**
 * Write a description of class w_6_q4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class w_6_q4
{
    public static void main(String[] args){
        int[] num={10,20,30,40,50};
        int sum=0;
        int avg=0;
        int max=num[0];
        int min=num[0];
        for(int i=0;i<num.length;i++)
        {
            System.out.println(num[i]);
            sum=sum+num[i]; 
            avg=sum/num.length;
            if(num[i]>max)
            {
                max=num[i];
            }
            if(num[i]<min)
            {
                min=num[i];
            }
        }
        System.out.println("The Sum is:"+sum);
        System.out.println("The avg is:"+avg);
        System.out.println("The max is:"+max);
        System.out.println("The max is:"+min); 
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of Array you wanna print");
        int a=scan.nextInt();
        int[] subjects=new int[a];
        for(int i=0;i<subjects.length;i++)
        {
            System.out.println("Enter the marks:");
            int in=scan.nextInt();
            subjects[i]=in;
        }
        for(int i=0;i<subjects.length;i++)
        {
            System.out.println(subjects[i]);
        }       
    }
}