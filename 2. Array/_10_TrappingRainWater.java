//Trapped Water Problem.(Problem 2.1)
public class _10_TrappingRainWater{

    public static int trappedRainWater(int[] arr){
        if(arr == null||arr.length == 0)return 0;

        int n = arr.length;
        int LeftMax[] = new int[n];
        int RightMax[] = new int[n];

        LeftMax[0] = arr[0];
        for(int i = 1;i < n;i++){
            LeftMax[i] = Math.max(arr[i], LeftMax[i-1]);
        }

        RightMax[n-1] = arr[n-1];
        for(int i = n-2;i >=0;i--){
            RightMax[i] = Math.max(arr[i], RightMax[i+1]);
        }

        int TrappedWater = 0;
        for(int i = 1;i < n-1;i++){
            int WaterLevel = Math.min(LeftMax[i], RightMax[i]);
            TrappedWater += Math.max(0,(WaterLevel-arr[i]));
        }
        
        return TrappedWater;
    }

    public static int trappedRainWater2(int[] heights) {
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
        int arr[] = {4,2,0,6,3,2,5};
        System.out.println(trappedRainWater(arr));
    }
}