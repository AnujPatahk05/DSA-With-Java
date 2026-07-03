/*
    930. Binary Subarrays With Sum
    (Medium)

    Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
    A subarray is a contiguous part of the array.

    Example 1:

    Input: nums = [1,0,1,0,1], goal = 2
    Output: 4
    Explanation: The 4 subarrays are bolded and underlined below:
    1, 0, 1
    1, 0, 1, 0
    0, 1, 0, 1
    1, 0, 1

    Example 2:

    Input: nums = [0,0,0,0,0], goal = 0
    Output: 15
*/



import java.util.HashMap;


public class BinarySubarraysWithSum {
    // Brute force approach
    // TC: O(n^2)
    // SC: O(1)
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;

        for(int i = 0;i < nums.length;i++) {
            int currCount = 0;
            for(int j = i;j < nums.length;j++) {
                currCount += nums[j];
                if(currCount == goal) {
                    count++;
                }
            }
        }

        return count;
    }

    // Optimal Sol: Prefix Sum + HashMap
    // Used in -> 560. Subarray Sum Equals K
    // TC: O(n)
    // SC: O(n)
    public static int numSubarraysWithSum2(int[] nums,int goal) {
        int count = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += nums[i];
            count += map.getOrDefault(sum-goal, 0);
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    // Sliding window approach (My Solution)
    // TC: O(n²) (worst case, due to rescanning consecutive zeros)
    // SC: O(1)
    public static int numSubarraysWithSum3(int[] nums,int goal) {
        int n = nums.length;

        int count = 0;

        int left = 0;
        int right = 0;
        int sum = nums[0];

        while(left < n && right < n && left <= right) {
            if(sum > goal) {
                if(left == right && left <= n-1 && right < n-1) {
                    sum -= nums[left];
                    left++;
                    right++;
                    sum += nums[right];
                } else {
                    sum -= nums[left];
                    left++;
                }
            } else if (sum < goal) {
                if(right >= n-1) {
                    break;
                }
                right++;
                sum += nums[right];
            } else {
                count++;

                int tempLeft = left;
                while(tempLeft <= right && nums[tempLeft++] == 0) {
                    if(tempLeft - 1 == right) {
                        continue;
                    }
                    count++;
                }

                int tempRight = right+1;
                while(tempRight <= n-1 && nums[tempRight++] == 0) count++;

                if(left <= n-1 && right < n-1) {
                    sum -= nums[left];
                    left++;
                    right++;
                    sum += nums[right];
                } else {
                    break;
                }
            
            }
        }

        return count;
    }

    // Optimal Solution using sliding window
    // Main idea: Exactly(goal) = AtMost(goal) − AtMost(goal − 1)
    // TC: O(n)
    // SC: O(1)
    public static int numSubarraysWithSum4(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println("Ans: "+numSubarraysWithSum4(new int[]{1,0,1,0,1}, 2));//4
        System.out.println("Ans: "+numSubarraysWithSum4(new int[]{0,0,0,0,0}, 0));//15
        System.out.println("Ans: "+numSubarraysWithSum4(new int[]{1,0,0,1,1,0,1,0,1}, 2));//11
        System.out.println("Ans: "+numSubarraysWithSum4(new int[]{1,1,0,1,0,1}, 2));//6
        System.out.println("Ans: "+numSubarraysWithSum4(new int[]{1,0,1,1,0,1,0,1}, 2));//9
        System.out.println("Ans: "+numSubarraysWithSum4(new int[]{1,0,0,0,0,0,0,1,0,1,0,1,1,1,1,0,0},2));//24
        System.out.println("Ans: "+numSubarraysWithSum4(new int[]{0,0,0,0,0,0,1,0,0,0}, 0));//27
        System.out.println("Ans: "+numSubarraysWithSum4(new int[]{0,0}, 0));//3

    }
}
