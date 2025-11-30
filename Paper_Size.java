import java.util.Scanner;

/**
 * Write a description of class Paper_Size here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Paper_Size
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Paper Size:");
        String Type=scan.nextLine();
        switch(Type)
        {
            case "A0":
            {
            System.out.println(" 841 x 1189 mm(33.1 x 46.8 inches)");
        }
        case "A1":
            {
            System.out.println(" 594 x 841 mm (23.4 x 33.1 inches)");
        }
        case "A2":
            {
            System.out.println(" 420 x 594 mm (16.5 x 23.4 inches)");
        }
        case "A3":
            {
            System.out.println("210 x 297 mm (8.3 x 11.7 inches)");
        }
        case "A4":
            {
            System.out.println("148 x 210 mm (5.8 x 8.3 inches)");
        }
    }
}
}