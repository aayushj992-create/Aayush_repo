
/**
 * Write a description of class w_6_q6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class w_6_q6
{
    public static void main(String[] args){
        int[][] marks={{80,75},{90,85}};
        System.out.println("Students\t"+"\t Nepali\t"+"English");
        int a=1;
        for(int i=0;i<marks.length;i++){
            int sum=a+i;
            System.out.print("Student"+sum);
            System.out.print(":");
            for(int j=0;j<marks[i].length;j++){
                System.out.print("\t"+marks[i][j]);
                System.out.println();
                
            }
            System.out.println();
        }
    }
}