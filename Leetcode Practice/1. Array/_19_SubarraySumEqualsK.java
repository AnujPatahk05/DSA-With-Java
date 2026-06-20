/*
    560. Subarray Sum Equals K
    (Medium)

    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.

    Example:

    Input: nums = [1,1,1], k = 2
    Output: 2
*/

import java.util.HashMap;

public class _19_SubarraySumEqualsK {
    // Brute force Approach
    // PrefixSum solution with O(n²)
    //  Time Complexity  : O(n²)
    //  Space Complexity : O(n)
    public static int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];

        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        int count = 0;
        for(int i = 0;i < nums.length;i++) {
            for(int j = i;j < nums.length;j++) {
                // Sum(i,j) = sum(0,j) - sum(0,i-1)
                if(prefixSum[j] - (i != 0 ? prefixSum[i-1] : 0) == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // Brute force Approach : without using extra space for prefixSum
    // Solving by a running sum
    //  Time Complexity  : O(n²)
    //  Space Complexity : O(1)
    public static int subarraysSum2(int[] nums,int k) {
        int count = 0;

        for(int i = 0;i < nums.length;i++) {
            int sum = 0;
            for(int j = i; j < nums.length;j++) {
                sum += nums[j];
                if(sum == k) count++;
            }
        }

        return count;
    }

    // Optimal Solution: PrefixSum + HashMap
    // We finds right boundary and checks for suitable left boundary 
    // TC: O(n)
    // SC: O(n)
    public static int subarraySum3(int[] nums,int k) {
        int count = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += nums[i];
            count += map.getOrDefault(sum-k, 0);
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] input = {1,1,1};
        System.out.println(subarraySum3(input, 2));

        int[] input2 = {4,1,5,2,3,2,0};
        System.out.println(subarraySum3(input2, 5));
    }
}
