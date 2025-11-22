import java.util.Scanner;

/**
 *Rickshaw Fare System
 *
 * Aayush Joshi
 * 101
 */
public class RickshawFare
{
    public static void main(String[] args){
        int base_fare=20;
        int per_kilometer_charge=2;
        int per_minute_charge=2;
        int surcharge=100;
        //discount for locals=40
        int discount=40;
        System.out.println("---------------------------------");
        System.out.println("The base_fare is:Rs"+base_fare);
        System.out.println("The per_kilometer_charge is:Rs"+per_kilometer_charge);
        System.out.println("The per_minute_charge is:Rs"+per_minute_charge);
        System.out.println("The surcharge is:Rs"+surcharge);
        System.out.println("---------------------------------");
        Scanner scan=new Scanner(System.in);
        //Distance fare 
        System.out.println("Enter the distance:");
        int distance=scan.nextInt();
        System.out.println("Your distance is:"+distance +"km");
        int total_distance_fare=per_kilometer_charge*distance;
        System.out.println("Your total distance fare is:Rs"+total_distance_fare);
        System.out.println("---------------------------------");
        //Time fare
        System.out.println("Enter the time in minutes:");
        int time=scan.nextInt();
        System.out.println("Your time is:"+time +"min");
        int total_time_fare=per_minute_charge*time;
        System.out.println("Your total distance fare is:Rs"+total_time_fare);
        int price=total_distance_fare*total_time_fare;
        System.out.println("Your fare before discount is:Rs"+price);
        System.out.println("---------------------------------");
        //For Local Or Not
        System.out.println("Are You a Local?Write 1 if Yes or 0 if No.:");
        Scanner local=new Scanner(System.in);
        int Dis=local.nextInt();
        int a=1;
        boolean b=(Dis==a);
        System.out.println(b);
        int Total_fare=(b==true)?(price-discount):(price+surcharge);
        System.out.println("=======================");
        System.out.println("Your Total Fare is:"+Total_fare);
        System.out.println("=======================");
    }
}