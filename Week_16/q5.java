package Week_16;
import java.util.Scanner;


/**
 * Write a description of class q5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q5
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter first string");
        String str1=scan.nextLine();
        StringBuilder wordCombination=new StringBuilder();
        StringBuilder newCombination=new StringBuilder();
        System.out.println("Enter second string");
        String str2=scan.nextLine();
        wordCombination=wordCombination.append(str1).append(str2);
        System.out.println(wordCombination);
        newCombination=newCombination.append(wordCombination).append(1239412).append("!#@$^&*$()").append(" ");
        System.out.println(newCombination);
        
        
    }
}