
/**
 * Write a description of class w_6_q7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class w_6_q7
{
 public static void main(String[] args){
     String[][] seats=new String[2][3];
     seats[0][0]="occupy";
     seats[0][1]="occupy";
     seats[0][2]="occupy";
     for(int i=0;i<seats.length;i++)
     {
         System.out.print("Seat plan:");
         for(int j=0;j<seats[i].length;j++)
         {
             if(seats[i][j]!=null)
             {
           System.out.print(seats[i][j]+" ");
             }
             
             else if(seats[i][j]==null)
             {
             System.out.print("Empty"+" ");      
         }
     }
     System.out.println();
    }
}
}


