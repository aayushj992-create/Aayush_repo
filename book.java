import java.util.Scanner;

/**
 * Write a description of class book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class book
{
   public static void main(String[] args)
   {
       Scanner scan=new Scanner(System.in);
       String[] categories = {"Fiction", "Nepali"};
       String[][] titles = new String[2][1]; 
       double[][] prices = new double[2][1];
       int sum=0;
       int add=0;
        for(int i=0;i<categories.length;i++){
            sum=sum+1;
             System.out.print("Title"+sum+":");
    String b=scan.nextLine();
        titles[i][0]=b;
    }
    
    for(int i=0;i<prices.length;i++){
        add=add+1;
        System.out.print("Price"+add+":");
    double a=scan.nextDouble();
        prices[i][0]=a;
    }
        
       System.out.print("Catagories:");
       for(int i=0;i<categories.length;i++)
       {
        System.out.print(categories[i]+" ");
    }
    System.out.println();
     System.out.print("Title:");
    for(int i=0;i<titles.length;i++){
        
        for(int j=0;j<titles[i].length;j++)
        {
            System.out.print("\t"+titles[i][j] +"\t");
        }
    }
    System.out.println();
    System.out.print("Price:");
    for(int i=0;i<prices.length;i++){
        for(int j=0;j<prices[i].length;j++)
        {
                System.out.print("\t"+"Rs."+prices[i][j]+" ");
        }
    }
       }
       }
    