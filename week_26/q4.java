package week_26;


/**
 * Write a description of class reverse_word here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q4
{
    public static int countOccurrence(int[] arr, int index, int key) {
        if (index == arr.length)
        {
            return 0;
        }
        int count;
        if(arr[index] == key)
        {
            count = 1;
        }
        else
        {
            count = 0;
        }
        return count + countOccurrence(arr, index + 1, key);
    }
    public static void main(String[] args) {
        int[] arr = {9, 3, 4, 4, 4, 4, 7, 6, 8};
        System.out.println(countOccurrence(arr, 0, 4));
    }
}
