/*
    1539. Kth Missing Positive Number
    (easy)

    Given an array arr of positive integers sorted in a strictly increasing order, 
    and an integer k.

    Return the kth positive integer that is missing from this array.

    Example 1:

    Input: arr = [2,3,4,7,11], k = 5
    Output: 9
    Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. 
    The 5th missing positive integer is 9.
*/

import java.util.Arrays;

public class KthMissingPositiveNumber {
    // Brute force approach with extra space
    // TC: O(n + k)
    // SC: O(k)
    public static int findKthPositive(int[] arr, int k) {
        int[] missings = new int[k];

        int idx = 0;

        for(int j = 1;j < arr[0];j++) {
            missings[idx] = j;
            if(idx == k-1){
                Arrays.stream(missings).forEach(System.out::println);
                return missings[k-1];
            }
            idx++;
        }

        for(int i = 0;i < arr.length-1;i++) {
            int start = arr[i] + 1;
            int end = arr[i+1];
            for(int j = start;j < end;j++) {
                missings[idx] = j;
                if(idx == k-1){
                    Arrays.stream(missings).forEach(System.out::println);
                    return missings[k-1];
                }
                idx++;
            }
        }

        int j = arr[arr.length-1]+1;
        while(true) {
            missings[idx] = j;
            if(idx == k-1){
                return missings[k-1];
            }
            idx++;
            j++;
        }
    }

    // Brute force approach without extra space
    // TC: O(n + k)
    // SC: O(k)
    public static int findKthPositive2(int[] arr, int k) {
        int idx = 0;
        int value = 1;

        for(int j = 1;j < arr[0];j++) {
            value = j;
            if(idx == k-1){
                return value;
            }
            idx++;
        }

        for(int i = 0;i < arr.length-1;i++) {
            int start = arr[i] + 1;
            int end = arr[i+1];
            for(int j = start;j < end;j++) {
                value = j;
                if(idx == k-1){
                    return value;
                }
                idx++;
            }
        }

        int j = arr[arr.length-1]+1;
        while(true) {
            value = j;
            if(idx == k-1){
                return value;
            }
            idx++;
            j++;
        }
    }

    // Binary Search approach
    // Missing numbers before arr[i] = arr[i] - (i + 1)
    // TC: O(log n)
    // SC: O(1)
    public static int findKthPositive3(int[] arr, int k) {
        int si = 0;
        int ei = arr.length - 1;

        int index = -1;
        int prevValue = -1;

        while(si <= ei) {
            int mid = si + (ei - si)/2;

            int value = arr[mid] - (mid+1);

            if(value >= k) {
                index = mid;
                prevValue = value;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        if(index != -1) {
            return arr[index] - (prevValue - k + 1);
        } else {
            return arr.length + k;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println("ans:"+findKthPositive3(arr, 5));
        

        int[] arr2 = {1,2,3,4};
        System.out.println("ans2: "+findKthPositive3(arr2, 5));
    }
}