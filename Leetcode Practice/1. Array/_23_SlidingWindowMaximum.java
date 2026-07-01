
import java.util.ArrayDeque;
import java.util.Deque;

/*
    239. Sliding Window Maximum
    (Hard)

    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left 
    of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves 
    right by one position.

    Return the max sliding window.

    Example 1:

    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]

    Explanation: 

    Window position                Max
    ---------------               -----
    [1  3  -1]  -3  5  3  6  7       3
    1  [3   -1  -3] 5  3  6  7       3
    1   3 [ -1  -3  5] 3  6  7       5
    1   3   -1 [-3  5  3] 6  7       5
    1   3   -1  -3 [5  3  6] 7       6
    1   3   -1  -3  5 [3  6  7]      7

*/

public class _23_SlidingWindowMaximum {

    /* 
         Maintain a monotonic decreasing deque of indices so that the front always represents 
         the maximum element of the current sliding window.
    */ 
   
    // TC: O(n)
    // SC: O(n)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int idx = 0;
        for(int i = 0;i < nums.length;i++) {
            while(!deque.isEmpty() && deque.peekFirst() <= i-k) 
                deque.pollFirst();

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) 
                deque.pollLast();

            deque.addLast(i);

            if(i >= k-1) result[idx++] = nums[deque.peekFirst()]; 
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        for(int i:result) {
            System.out.println(i);
        }

    }
}
