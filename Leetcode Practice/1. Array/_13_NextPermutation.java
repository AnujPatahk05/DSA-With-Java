
import java.util.ArrayList;
import java.util.Arrays;

public class _13_NextPermutation {
    private static int next = 0;

    public static void permutations(int[] nums,ArrayList<Integer> permutations,ArrayList<ArrayList<Integer>> all,boolean[] isUsed){
        if(permutations.size() == nums.length){
            all.add(new ArrayList<>(permutations));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                permutations.add(nums[i]);
                permutations(nums,permutations,all,isUsed);
                isUsed[i] = false;
                permutations.remove(permutations.size()-1);
            }
        }
    }

    public static void nextPermutation(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();

    }

    public static void nextPermutation2(int[] nums) {
        //Find the pivot element:
        int pivot = -1;
        for(int i = nums.length-2;i >= 0;i--){
            if(nums[i] < nums[i+1]){
                pivot = i;break;
            }
        }
        System.out.println(pivot);
        if(pivot == -1){
            Arrays.sort(nums);
            return;
        }

        int nextGreaterToPivot = -1;
        for(int i = nums.length-1;i >= 0;i--){
            if(nums[i] > nums[pivot]){
                nextGreaterToPivot = i;
                break;
            }
        }

        System.out.println(nextGreaterToPivot);
        

        int temp = nums[pivot];
        nums[pivot] = nums[nextGreaterToPivot];
        nums[nextGreaterToPivot] = temp;

        int i = pivot+1;
        int j = nums.length-1;
        while(i < j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }

        Arrays.stream(nums).mapToObj(n -> n+" ").forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        // ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
        // permutations(nums, new ArrayList<>(),allPermutations, new boolean[nums.length]);
        // System.out.println(allPermutations);
        nextPermutation2(nums);
    }
}
