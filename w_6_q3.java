import java.util.Scanner;

/**
 * Write a description of class w_6_q3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class w_6_q3
{
    public static void main(String[] args){
        String[] name={"Saroj","Sushant","Ujjwal", "Rabina", "Sandesh"};
        for(int i=0;i<name.length;i++){
           System.out.println(name[i]); 
        }
        System.out.println();
        System.out.println(name[2]);
        System.out.println();
        name[4]="Lucky";
        for(int i=0;i<name.length;i++){
           System.out.println(name[i]); 
        }
        System.out.println();
        Scanner scan=new Scanner(System.in);
        String a=scan.nextLine();
        name[3]=a;
        for(int i=0;i<name.length;i++){
           System.out.println(name[i]); 
        }
    }
}