import java.util.Scanner;

/**
 * Write a description of class income_tax here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class income_tax
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter you Annual Income:");
        float income=scan.nextFloat();
        if(income<=500000)
        {
            float total_tax=income*0.01f;
        System.out.println("The total tax is"+total_tax);
        }
        else if(income>500000 && income<=700000){
            float tax_1=500000*0.01f;
            float tax_2=income-500000;
            float tax_3=tax_2*0.1f;
            float total_tax=tax_1+tax_3+5000;
            System.out.println("The total tax is"+total_tax);
        }
        else if(income>700000 && income<=1000000)
        {
         float tax_1=500000*0.01f;
         float tax_2=200000*0.1f;
         float tax_3=income-700000;
         float tax_4=tax_3*0.2f;
         float total_tax=tax_1+tax_2+tax_4+15000;
         System.out.println("The total tax is"+total_tax);
        }
        else if(income>1000000 && income<=2000000)
        { 
         float tax_1=500000*0.01f;
         float tax_2=200000*0.1f;
         float tax_3=300000*0.2f;
         float tax_4=income-1000000;
         float tax_5=tax_4*0.3f;
         float total_tax=tax_1+tax_2+tax_3+tax_5+35000;
         System.out.println("The total tax is"+total_tax);
        }
        else if(income>2000000 && income<=5000000)
        { 
         float tax_1=500000*0.01f;
         float tax_2=200000*0.1f;
         float tax_3=300000*0.2f;
         float tax_4=1000000*0.3f;
         float tax_5=income-3000000;
         float tax_6=tax_5*0.36f;
         float total_tax=tax_1+tax_2+tax_3+tax_4+tax_6+335000;
         System.out.println("The total tax is"+total_tax);
        }
        else
        { 
         float tax_1=500000*0.01f;
         float tax_2=200000*0.1f;
         float tax_3=300000*0.2f;
         float tax_4=1000000*0.3f;
         float tax_5=3000000*0.36f;
         float tax_6=income-5000000;
         float tax_7=tax_6*0.39f;
         float total_tax=tax_1+tax_2+tax_3+tax_4+tax_5+tax_7+1135000;
         System.out.println("The total tax is"+total_tax);
        }    
}
}