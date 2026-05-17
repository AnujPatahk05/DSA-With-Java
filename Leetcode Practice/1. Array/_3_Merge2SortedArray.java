
import java.util.Arrays;

/*
    88. Merge Sorted Array
    (easy) --> https://dsa.apnacollege.in/

    You are given two integer arrays nums1 and nums2, sorted in non-decreasing 
    order, and two integers m and n, representing the number of elements in 
    nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead 
    be stored inside the array nums1. To accommodate this, nums1 has a length 
    of m + n, where the first m elements denote the elements that should be 
    merged, and the last n elements are set to 0 and should be ignored. 
    nums2 has a length of n.

    Example:

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output:        [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements 
    coming from nums1.
*/

public class _3_Merge2SortedArray {

    // 1.
    // Merging using extra array
    //  TC:O(m+n)
    //  SC:O(m)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);

        int i = 0;
        int j = 0;
        int idx = 0;

        while(i < m && j < n){
            nums1[idx++] = temp[i] <= nums2[j] ? temp[i++]: nums2[j++];
        }

        while(i < m){
            nums1[idx++] = temp[i++];
        }

        while(j < n){
            nums1[idx++] = nums2[j++];
        }
    }

    //  2.
    //  Merge 2 sorted array without extra space
    //  TC: O(m+n)
    //  SC: O(1)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        
        int idx = nums1.length-1;

        while(i >= 0 && j >= 0){
            nums1[idx--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while(i >= 0){
            nums1[idx--] = nums1[i--];
        }

        while(j >= 0){
            nums1[idx--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,5,9,30,67,0,0,0};
        int[] nums2 = {2,31,68};

        merge2(nums1, 5, nums2, 3);

        Arrays.stream(nums1).mapToObj(n -> n+" ").forEach(System.out::print);
    }
}