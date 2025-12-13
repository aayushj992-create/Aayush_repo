
/**
 * Write a description of class tutorial__6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class tutorial__6
{
    public static void main(String[] args){
        int[] age;
        age=new int[5];
        System.out.println(age.length);
        age[0]=10;
        age[1]=20;
        age[2]=30;
        age[3]=40;
        age[4]=50;
        //Accesing individual elements
        System.out.println(age[1]);
        //Traversing and array iterating an array
        int[] agr={10,20,30,40,50};//declaring and initializing an array
        for(int i=agr.length-1;i>=0;i--){
            System.out.println(agr[i]);
            
            //Matrix 2d array
            int [][] matrix;
            matrix=new int[2][2];
            matrix[0][0]=10;
            matrix[0][1]=20;
            matrix[1][0]=30;
            matrix[1][1]=40;
        }
            //2D Matrix in one line
            int[][] mat={{1,2,3},{4,5,6,7,8},{9,2,1,3,2}};//
            for(int i=0;i<mat.length;i++)
            {
            for(int j=0;j<mat[i].length;j++)
            {
                System.out.print(mat[i][j]);
            }
            System.out.println();
            }
        }
    }
