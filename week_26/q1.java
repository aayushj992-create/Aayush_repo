package week_26;


/**
 * Write a description of class reverse_word here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q1
{
    public static String reverse(String word)
    {
        if (word.isEmpty())
        {
            return word;
        }
        return reverse(word.substring(1))+word.charAt(0);
    }
    //Time Complexity-O(n)
    public static void main(String[] args)
    {
        String str="hello";
        System.out.println(reverse(str));
    }
}