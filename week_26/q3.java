package week_26;


/**
 * Write a description of class reverse_word here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q3 {
    public static int linearSearch(int[] arr, int index, int key) {
        if (index == arr.length)
        {
            return -1;
        }
        if (arr[index] == key)
        {
            return index;
        }
        return linearSearch(arr, index + 1, key);
    }
    public static void main(String[] args) {
        int[] arr = {7,6,9,1,2,5,6,8,10};
        System.out.println(linearSearch(arr, 0, 1));
    }
}