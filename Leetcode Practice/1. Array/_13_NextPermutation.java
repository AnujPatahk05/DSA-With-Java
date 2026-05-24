
import java.util.ArrayList;

public class _13_NextPermutation {
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

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
        permutations(nums, new ArrayList<>(),allPermutations, new boolean[nums.length]);
        System.out.println(allPermutations);
    }
}
