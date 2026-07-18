/*
    42. Trapping Rain Water
    (Hard)

    Given n non-negative integers representing an elevation map where the width of each bar is 1, 
    compute how much water it can trap after raining.

    Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
    In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9
*/

public class _24_TrappingRainWater {
    // Store Left max and right max for each bar
    // TC: O(n)
    // SC: O(n)
    public static int trap(int[] height) {
        int n = height.length;

        int[] rightMax = new int[n];
        int max = 0;

        for (int i = n-1;i >= 0;i--) {
            max = rightMax[i] = Math.max(max,height[i]);
        }

        int leftMax = 0;

        int water = 0;

        for (int i = 0;i < n;i++) {
            leftMax = Math.max(leftMax,height[i]);

            int waterLevel = Math.min(leftMax,rightMax[i]);
            water += Math.max(0,waterLevel - height[i]);
        }

        return water;
    }

    // Two pointer approach
    // TC: O(n)
    // SC: O(1)
    public static int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);

            if (leftMax < rightMax) {
                water += (leftMax - height[left]);
                left++;
            } else {
                water += (rightMax - height[right]);
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height1 = {4,2,0,6,3,2,5};
        System.out.println(trap(height1));
        System.out.println(trap2(height1));
        System.out.println(2%10);
    }
}
