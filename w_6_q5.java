
/**
 * Write a description of class w_6_q5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class w_6_q5
{
 public static void main(String[] args){
     String[] district={ "Morang", "Kathmandu","Kaski", "Sindhuli"};
     int sum=1;
     for(int i=0;i<district.length;i++)
     {
         int a=sum+i;
         System.out.println(a+"."+district[i]);
     }
 }
}