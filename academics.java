import java.util.Scanner;

/**
 * Write a description of class academics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class academics
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter GPA");
        float GPA=scan.nextFloat();
        System.out.println("Enter Attendance");
        float Attendance=scan.nextFloat();
        System.out.println("Enter Attitude");
        int Attitude=scan.nextInt();
    if(GPA>=0.0 && GPA<=4.0)
    {
            if(GPA>=3.2)
            {
            if(Attendance>0.80)
            {
                if(Attitude<5)
                {
                    System.out.println("You are Eligible for Scholarship");
                }
                else
                {
                    System.out.println("You have low Attitude");
                }
            }
                else
                {
                    System.out.println("You have low Attendance");
                }
            }
                else
                {
                    System.out.println("You have low GPA");
                }
              
        
    }
    else 
                {
                    System.out.println("You are not Eligible for Scholarship");
                }
    }
        }
        
