import java.util.Scanner;

/**
 * Write a description of class Sales here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sales
{ 
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter catagory:");
        char catagory=scan.next().charAt(0);
        System.out.println("Enter MP:");
        float Mp=scan.nextFloat();
        if(catagory=='A'){
            float Sp=Mp-(Mp*0.60f);
            System.out.println("Your selling price is:"+Sp);
        }
        else if(catagory=='B'){
            float Sp=Mp-(Mp*0.40f);
            System.out.println("Your selling price is:"+Sp);
        }
        else if(catagory=='C'){
            float Sp=Mp-(Mp*0.20f);
            System.out.println("Your selling price is:"+Sp);
        }
        else if(catagory=='D'){
            float Sp=Mp-(Mp*0.10f);
            System.out.println("Your selling price is:"+Sp);
        }  
        else{
           System.out.println("You don't have any discount"); 
        }
    }
}