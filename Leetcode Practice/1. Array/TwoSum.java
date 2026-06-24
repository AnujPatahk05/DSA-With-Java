/*
    1. Two Sum
    (easy)

    Given an array of integers nums and an integer target, return indices of the two numbers 
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/


import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // Sorting + 2 pointer approach
    // TC: O(n log n)  because of sorting + linear traversal to all elements
    // SC: O(n)
    public static int[] twoSum(int[] nums, int target) {
        int[][] pairs = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (pairs[i][0] + pairs[j][0] == target) {
                return new int[]{
                    pairs[i][1], 
                    pairs[j][1]
                };
            }

            if (pairs[i][0] + pairs[j][0] > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[0];
    }

    // HashMap approach
    // TC: O(n)
    // SC: O(n)
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++) {
            int need = target - nums[i];

            if(map.containsKey(need)) {
                return new int[]{
                    map.get(need),
                    i
                };
            }

            map.put(nums[i],i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] input1 = {2, 7, 11, 15};
        int[] output1 = twoSum2(input1, 9);
        System.out.println(output1[0] + " " + output1[1]);

        int[] input2 = {3, 2, 4};
        int[] output2 = twoSum2(input2, 6);
        System.out.println(output2[0] + " " + output2[1]);
    }
}
