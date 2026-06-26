/*
    977. Squares of a Sorted Array
    (easy)

    Given an integer array nums sorted in non-decreasing order, return an array of 
    the squares of each number sorted in non-decreasing order.

    Example:

    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
*/

import java.util.Arrays;

public class SquaresOfaSortedArray {
    // Sorting approach
    // TC: O(n log n)
    // SC: O(n)
    public static int[] sortedSquares1(int[] nums) {
        int[] result = new int[nums.length];

        for(int i = 0;i < nums.length;i++) {
            result[i] = nums[i]*nums[i];
        }

        Arrays.sort(result);

        return result;
    }


    // Two pointer approach: Optimal solution
    // TC: O(n)
    // SC: O(n)
    public static int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int p1 = 0;

        for(int i = 0;i < nums.length;i++) {
            if(nums[i] >= 0) {
                p1 = i;
                System.out.println("p1 = "+ p1);
                break;
            }
        }

        int p2 = p1 - 1;

        int idx = 0;
        while(p1 < nums.length && p2 >= 0) {
            int s1 = nums[p1]*nums[p1];
            int s2 = nums[p2]*nums[p2];

            if(s1 <= s2) {
                result[idx++] = s1;
                p1++;
            }else {
                result[idx++] = s2;
                p2--;
            }
        }
        
        while(p1 < nums.length) {
            int s1 = nums[p1]*nums[p1];
            result[idx++] = s1;
            p1++;
        }

        while(p2 >= 0) {
            int s2 = nums[p2]*nums[p2];
            result[idx++] = s2;
            p2--;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] input1 = {-4,-1,0,3,10};
        int[] output1 = sortedSquares2(input1);
        
        Arrays.stream(output1).forEach(System.out::println);
    }
}