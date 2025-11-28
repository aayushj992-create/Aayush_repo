import java.util.Scanner;

/**
 * Write a description of class switching here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class switching
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Catagory:");
        char catagory=scan.next().charAt(0);
        System.out.println("Enter Mp:");
        float Mp=scan.nextFloat();
        switch(catagory){
            case 'A':{
            float Sp=Mp-(Mp*0.60f);
            System.out.println("Your selling price is:"+Sp);
        }
        break;
        case 'B':{
            float Sp=Mp-(Mp*0.40f);
            System.out.println("Your selling price is:"+Sp);
        }
        break;
        case 'C':{
            float Sp=Mp-(Mp*0.20f);
            System.out.println("Your selling price is:"+Sp);
        }
        break;
        case 'D':{
            float Sp=Mp-(Mp*0.10f);
            System.out.println("Your selling price is:"+Sp);
        }
        break;
        default:System.out.println("You don't have any discount:"+Mp);
    }
    }
}