/*
    287. Find the Duplicate Number
    (Medium)

    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

    There is only one repeated number in nums, return this repeated number.

    You must solve the problem without modifying the array nums and using only constant extra space.

    
    Example 1:
    Input: nums = [1,3,4,2,2]
    Output: 2

    Example 2:
    Input: nums = [3,1,3,4,2]
    Output: 3

    Example 3:
    Input: nums = [3,3,3,3,3]
    Output: 3
*/

import java.util.HashSet;

public class _20_FindtheDuplicateNumber {
    // Solution using extra O(n) space : set
    public static int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) {
            if(set.contains(num)) {
                return num;
            }else{
                set.add(num);
            }
        }

        return -1;
    }

    // Solution using Constant space O(1)
    // Floyds cycle detection (slow - fast) approach
    // The starting point of the cycle is the duplicate element
    // TC: O(n)
    // SC: O(1)
    public static int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        slow = 0;
        System.out.println("slow:"+slow);
        System.out.println("fast"+fast);

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] input1 = {1,3,4,2,2};
        //              0 1 2 3 4

        //      0 -> 1 -> 3 -> 2 -> 4
        //                      ^___|
        //
        System.out.println(findDuplicate2(input1));

        int[] input2 = {3,1,3,4,2};
        System.out.println(findDuplicate2(input2));
    }
}
