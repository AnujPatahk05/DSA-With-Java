
import java.util.HashMap;

/*
169. Majority Element
(easy) --> https://dsa.apnacollege.in/

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

public class _1_MajorityElement {

    //1.
    // Divide and conquer approach : TC: O(n log n)
    //                               SC: O(log n)
    private static int majorityElementP(int[] arr, int si, int ei) {
        if (si == ei) {
            return arr[si];
        }

        int mid = si + (ei - si) / 2;

        int left = majorityElementP(arr, si, mid);
        int right = majorityElementP(arr, mid + 1, ei);

        if (left == right) {
            return left;
        }

        int leftCount = 0;
        int rightCount = 0;

        for (int i = si; i <= ei; i++) {
            if (arr[i] == left) {
                leftCount++;
            }
            if (arr[i] == right) {
                rightCount++;
            }
        }

        return leftCount > rightCount ? left : right;
    }

    public static int majorityElement(int[] nums) {
        return majorityElementP(nums, 0, nums.length - 1);
    }

    //2.
    //HashMap Approach: TC: O(n)
    //                  SC: O(n)
    public static int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }

    //3. (Optimal)
    //Moore's Voting Algorithm: TC:O(n)
    //                          SC:O(1)

    public static int majorityElement3(int[] nums){
        int freq = 0;
        int ans = 0;
        for(int num:nums){
            if(freq == 0) ans = num;
            
            if(ans == num) freq++;
            else freq--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(nums));
    }
}
