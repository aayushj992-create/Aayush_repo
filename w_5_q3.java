
/**
 * Write a description of class w_5_q3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class w_5_q3
{
    public static void main(String[] args){
        int i=1;
        int sum=0;
        do{
            int square=i*i;
            sum=sum+square;
            System.out.println(sum);
            i++;
        }while(i<=10);
    }
}