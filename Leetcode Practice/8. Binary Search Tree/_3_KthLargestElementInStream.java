
import java.util.TreeMap;

public class _3_KthLargestElementInStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(4, new int[]{7,7,7,7,8,3});
        // System.out.println(kthLargest.add(2));
    }
}

// Sol:
class KthLargest {
    int k;
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num:nums) {
            map.put(num,num);
        }

        while (map.size() != k) {
            System.out.println(map.firstKey());
            map.remove(map.firstKey());
        }
    }
    
    public int add(int val) {
        map.put(val,val);
        map.remove(map.firstKey());
        return map.firstKey();
    }
}