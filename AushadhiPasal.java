import java.util.Scanner;

/**
 *AushadhiPasal Dharan
 *
 * @author Aayush Joshi
 * @version v7
 */
public class AushadhiPasal
{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Name of Medicine:");
                String Name=scan.nextLine();
        System.out.println("Enter Information Of Medicine:");
        String Info=scan.nextLine();
        System.out.println("Enter Price per tabelet of medicine:");
        double Price=scan.nextDouble();
        System.out.println("Enter Stock left of Medicine:");
        int Stock=scan.nextInt();
        System.out.println("================================================");
        System.out.println("\t Welcome to Aausadhi Pasal Dharan \t");
        System.out.println("================================================");
        System.out.println("\tName of Medicine:"+Name);
        System.out.println("\tDescription of Medicine:"+Info);
        System.out.println("\tPrice per tablet of Medicine:"+Price);
        System.out.println("\tStock of Medicine:"+Stock);
        System.out.println("================================================");
    }
}