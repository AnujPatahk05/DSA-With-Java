import java.util.Arrays;

public class _3_MinSumOfAbsoluteDiffPair {
    public static int minSumOfAbsoluteDiffPair1(int[] A,int[] B){//My way O(n^2)
        boolean[] isPicked = new boolean[A.length];

        int sum = 0;
        for(int i = 0;i < A.length;i++){
            int minVal = Integer.MAX_VALUE;
            int minIdx = 0;

            for(int j = 0;j < B.length;j++){
                if(isPicked[j]){
                    continue;
                }

                if(Math.abs(A[i]-B[j]) < minVal){
                    minVal = Math.abs(A[i]-B[j]);
                    minIdx = j;
                }
            }

            isPicked[minIdx] = true;
            sum += Math.abs(A[i]-B[minIdx]);
        }
        
        return sum;
    }

    public static int minSumOfAbsoluteDiffPair2(int[] A,int[] B){//O(n)
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for(int i = 0;i < A.length;i++){
            minDiff += Math.abs(A[i]-B[i]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {2,1,3};

        System.out.println(minSumOfAbsoluteDiffPair1(A, B));

        int[] C = {4,1,8,7};
        int[] D = {2,3,6,5};

        System.out.println(minSumOfAbsoluteDiffPair2(C, D));
    }
}
