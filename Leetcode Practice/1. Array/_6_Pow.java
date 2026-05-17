public class _6_Pow {
    // Optimal way to find pow(x,n)
    // TC: O(log n)
    // SC: O(log n)
    private static double pow(double x, int n) {
        if(n == 0) return 1;
        double half = pow(x,n/2);
        if(n%2 == 0) return half*half;
        else return x*half*half;
    }

    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n > 0){
            return pow(x,n);
        }else{
            n = -1*n;
            return (double)1/pow(x,n);
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -1));
    }
}
