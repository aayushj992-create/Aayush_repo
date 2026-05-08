package week_26;


/**
 * Write a description of class q5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q5
{
    public static int findPeak(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        boolean leftCheck = (mid == 0 || arr[mid] >= arr[mid - 1]);
        boolean rightCheck = (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]);
        if (leftCheck && rightCheck)
        {
            return mid;
        }
        if (mid > 0 && arr[mid - 1] > arr[mid])
        {
            return findPeak(arr, left, mid - 1);
        }
        return findPeak(arr, mid + 1, right);
    }
    public static void main(String[] args) {
        int[] arr = {12, 1, 7, 3, 4, 7, 8};
        int peakIndex = findPeak(arr, 0, arr.length - 1);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }

}