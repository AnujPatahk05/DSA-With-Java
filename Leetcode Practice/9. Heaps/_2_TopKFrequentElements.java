/*
    347. Top K Frequent Elements
    (Medium)

    Given an integer array nums and an integer k, return the k most frequent elements. 
    You may return the answer in any order.

    Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2

    Output: [1,2]
*/
import java.util.HashMap;
import java.util.PriorityQueue;

public class _2_TopKFrequentElements {
    // My Sol
    // TC: O(m*k) -> m: no of dist elements, Worst case: TC: O(n^2)
    // SC: O(m)
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] output = new int[k];

        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for (int i = 0;i < k;i++) {
            int maxFreq = 0;
            int value = 0;

            for (int key:map.keySet()) {
                if (map.get(key) > maxFreq) {
                    maxFreq = map.get(key);
                    value = key;
                }
            }

            output[i] = value;
            map.remove(value);
        }

        return output;
    }

    // Using Max Heap
    // TC: O(n + m log m)
    // SC: O(m)
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num:nums) {
            map.put(num,map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for (int num:map.keySet()) {
            pq.add(num);
        }

        int[] output = new int[k];

        for (int i = 0;i < k;i++) {
            output[i] = pq.poll();
        }

        return output;
    }

    // Using min heap
    // Time: O(n + m log k)
    // Space: O(m + k)
    public static int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num:nums) {
            map.put(num,map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for (int num:map.keySet()) {
            pq.add(num);

            if (pq.size() > k) pq.poll();
        }

        int[] output = new int[k];

        for (int i = k - 1;i >= 0;i--) {
            output[i] = pq.poll();
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        int[] output = topKFrequent(nums, 2);

        System.out.println(output[0]);
        System.out.println(output[1]);
    }
}
