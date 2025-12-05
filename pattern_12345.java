
/**
 * Write a description of class pattern_12345 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pattern_12345
{
    public static void main(String[] args)
    {
        for (int i=1; i<=5; i++)
        {
            for(int k= 5; k >=i; k--)//this is to give space along side the j code numbers so the pattern comes
            {
                System.out.print(" ");
            }
            
            for (int j=1; j<=i;j++)
            {
            System.out.print(j);// we dont use println so that the output is in the same line 
            }
            
           System.out.println();//it breaks the line // /n gives 1 line of space but this just makes the other output in the very neext line
    
   }
}
}