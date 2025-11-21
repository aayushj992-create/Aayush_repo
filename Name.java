import java.util.Scanner;

/**
 * Name 
 *
 * @author (Aayush Joshi)
 * @version (a version number or a date)
 */
public class Name
{
    public static void main(String[] args){
        System.out.println("My name is");
        System.out.println("Aayush Joshi");  
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Name");
        String Name=scan.nextLine();
        System.out.println("Your Name is:"+Name);
    }
}