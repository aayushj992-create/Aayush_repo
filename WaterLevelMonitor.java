import java.util.Scanner;

/**
 * Write a description of class WaterLevelMonitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WaterLevelMonitor
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the current water level:");
        int level=scan.nextInt();
        System.out.println("The water level is:"+level);
        String Message=(level>=1000)?"WARNING :Water level has reached 1000L or More!":"Status:Normal";
        System.out.println(Message);
    }
}