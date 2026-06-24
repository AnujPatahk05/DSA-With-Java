/*
    217. Contains Duplicate
    (easy)

    Given an integer array nums, return true if any value appears at least twice 
    in the array, and return false if every element is distinct.

    Example:

    Input: nums = [1,2,3,1]
    Output: true

    Explanation:
    The element 1 occurs at the indices 0 and 3.
*/

import java.util.HashSet;

public class ContainsDuplicate {
    // TC: O(n)
    // SC: O(n)
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num:nums) {
            if(!set.add(num)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] input1 = {1,2,3,1};
        System.out.println(containsDuplicate(input1));
    }
}
