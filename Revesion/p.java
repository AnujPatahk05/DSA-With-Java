
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class p {
    // TC: O(n^2)
    // SC: O(n^2)
    public static List<List<Integer>> pairs(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0;i < arr.length;i++) {
            for (int j = i+1;j < arr.length;j++) {
                result.add(List.of(arr[i],arr[j]));
            }
        }

        return result;
    }

    // TC: O(n^3)
    // SC: O(n^3)
    public static List<List<Integer>> subarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0;i < arr.length;i++) {
            List<Integer> subarray = new ArrayList<>();

            for (int j = i;j < arr.length;j++) {
                subarray.add(arr[j]);
                result.add(new ArrayList<>(subarray));
            }
        }

        return result;
    }

    // HashMap approach
    // TC: O(n)
    // SC: O(n)
    public static int[] twoSum(int[] arr,int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i < arr.length;i++) {
            int need = target - arr[i];

            if (map.containsKey(need)) {
                return new int[] {
                    map.get(need),
                    i
                };
            }

            map.put(arr[i],i);
        }

        return new int[0];
    }

    // Kadanes Theorem
    //
    public static int maxSubarraySum(int[] arr) {
        if (arr.length == 0) return 0;

        int currSum = arr[0];
        int maxSum = arr[0];

        for (int num:arr) {
            currSum = Math.max(currSum + num,num);
            maxSum = Math.max(currSum,maxSum);
        }

        return maxSum;
    }

    public static int trappedRainWater(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;

        int[] rightMax = new int[n];
        int max = 0;

        for(int i = n-1;i >= 0;i--) {
            max = rightMax[i] = Math.max(max,heights[i]);
        }

        int leftMax = 0;

        int water = 0;
        for (int i = 0;i < n;i++) {
            leftMax = Math.max(leftMax,heights[i]);
            int waterLevel = Math.min(leftMax,rightMax[i]);

            water += Math.max(0,waterLevel - heights[i]);
        }

        return water;
    }

    public static void main(String[] args) {
    }

}
