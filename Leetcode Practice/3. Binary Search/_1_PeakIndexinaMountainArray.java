/*
    852. Peak Index in a Mountain Array
    (Medium)

    You are given an integer mountain array arr of length n where the values increase to a 
    peak element and then decrease.

    Return the index of the peak element.

    Your task is to solve it in O(log(n)) time complexity.

    Example 1:
    Input: arr = [0,1,0]
    Output: 1
*/

public class _1_PeakIndexinaMountainArray {
    // TC: O(log n)
    // SC: O(1)
    public static int peakIndexInMountainArray(int[] arr) {
        int si = 1;
        int ei = arr.length-2;

        while(si <= ei) {
            int mid = si + (ei - si)/2;

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) 
                return mid;

            if(arr[mid-1] < arr[mid]) 
                si = mid+1;
            else
                ei = mid-1;
            
        }

        return -1;
    }

    // TC: O(log n)
    // SC: O(1)
    public static int peakIndexInMountainArray2(int[] arr) {
        int si = 0;
        int ei = arr.length-1;

        while(si < ei) {
            int mid = si + (ei - si)/2;

            if(arr[mid] < arr[mid+1]) {
                si = mid+1;
            }else{
                ei = mid;
            }
        }

        return si;
    }

    public static void main(String[] args) {
        int[] input = {1,2,4,6,18,90,89,39,6};
        System.out.println(peakIndexInMountainArray(input));
    }
}
