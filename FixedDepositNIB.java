import java.util.Scanner;
/**
 * Write a description of class FixedDepositNIB here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FixedDepositNIB
{
    public static void main(String[] args){
        float processing_fees=0.005f;
        float interest=0.08f;
        
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter y to continue or Enter n to discontinue calculation:");
        char option=scan.next().charAt(0);
        System.out.println("Enter a for yearly,q for quarterly,h for half-yearly and m for monthly");
        char payement_time=scan.next().charAt(0);
        System.out.println("Enter the deposited amount:");
        float Principle=scan.nextFloat();
        System.out.println("Enter time duration:");
        float Time=scan.nextInt();
        System.out.println("The deposited amount is:Rs  "+Principle);
        System.out.println("The time duration is:"+Time+"years");
        while(option=='y')
        {
            if(Principle>1000 && Time<6){
                if(payement_time=='a'){
                float years=1+interest;
                double yearly=Math.pow(years,Time);
                double total_amount=Principle*yearly;
                System.out.println("The total is:"+total_amount);
                double fees_amount=total_amount*processing_fees;
                double total=total_amount-fees_amount;
                float final_product=(float)total;
                System.out.println("Your Total amount after deducting processing fees is:"+final_product);
            }
            else if(payement_time=='q'){
                float years=(1+(interest/4f));
                double yearly=Math.pow(years,Time*4);
                double total_amount=Principle*yearly;
                System.out.println("The total is:"+total_amount);
                double fees_amount=total_amount*processing_fees;
                double total=total_amount-fees_amount;
                float final_product=(float)total;
                System.out.println("Your Total amount after deducting processing fees is:"+final_product);
            }
            else if(payement_time=='h'){
                float years=(1+(interest/2f));
                double yearly=Math.pow(years,Time*2);
                double total_amount=Principle*yearly;
                System.out.println("The total is:"+total_amount);
                double fees_amount=total_amount*processing_fees;
                double total=total_amount-fees_amount;
                float final_product=(float)total;
                System.out.println("Your Total amount after deducting processing fees is:"+final_product);
            }
            else if(payement_time=='m'){
                float years=(1+(interest/12f));
                double yearly=Math.pow(years,Time*12);
                double total_amount=Principle*yearly;
                System.out.println("The total is:"+total_amount);
                double fees_amount=total_amount*processing_fees;
                double total=total_amount-fees_amount;
                float final_product=(float)total;
                System.out.println("Your Total amount after deducting processing fees is:"+final_product);
            }
        }
        else{
                System.out.println("You cannot deposite the amount less than 1000 and more than 5 years");
            }
            break;
        }
}
}
