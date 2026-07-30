// package Revesion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


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

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price:prices) {
            maxProfit = Math.max(maxProfit,price - minPrice);
            minPrice = Math.min(minPrice,price);
        }
       
        return maxProfit;
    }

    // TC: O(n^2)
    // SC: O(1)
    public static void bubbleSort(int[] arr) {
        for (int i = 0;i < arr.length;i++) {
            for (int j = 0;j < arr.length - i - 1;j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; 
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for(int i = 0;i < arr.length - 1;i++) {
            int minIndex = i;
            
            for (int j = i+1;j < arr.length;j++) {
                if(arr[j] < arr[minIndex]) minIndex = j;
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1;i < arr.length;i++) {
            int curr = arr[i];
            int prevIdx = i - 1;
            while(prevIdx >= 0 && curr < arr[prevIdx]) {
                arr[prevIdx + 1] = arr[prevIdx];
                prevIdx--;
            }
            arr[prevIdx + 1] = curr;
        }
    }

    public static void countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i:arr) {
            max = Math.max(max,i);
        }

        int[] countArr = new int[max+1];

        for(int i:arr) {
            countArr[i]++;
        }

        int idx = 0;
        for(int i = 0;i < countArr.length;i++) {
            while(countArr[i] > 0) {
                arr[idx++] = i;
                countArr[i]--;
            }
        }
    }

    public static String largestString(String str,String... strs) {
        String largest = str;
        
        for (String s: strs) {
            if (largest.compareTo(s) < 0) {
                System.out.println("Hello");
                largest = s;
            }
        }

        return largest;
    }

    public static String alphabetString() {
        StringBuilder sb = new StringBuilder();
        for (char ch = 'A';ch <= 'Z';ch++) {
            sb.append(ch);
        } 
        return sb.toString();
    }

    public static String toUpperCase(String sentence) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(sentence.charAt(0)));

        for (int i = 1;i < sentence.length();i++) {
            sb.append(
                sentence.charAt(i - 1) != ' ' ?
                sentence.charAt(i):
                Character.toUpperCase(sentence.charAt(i))
            );
        }

        return sb.toString();
    }

    public static String removeWhiteSpaces(String sentence) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < sentence.length() && sentence.charAt(i) == ' ') {
            i++;
        }

        while (i < sentence.length()) {
            char ch = sentence.charAt(i);
            if (!(ch == ' ' && sentence.charAt(i-1) == ' ')) {
                result.append(ch);
            }
            i++;
        }

        if (result.length() > 0 && result.charAt(result.length()-1) == ' ') {
            result.deleteCharAt(result.length()-1);
        }
            
        return result.toString();
    }

    public static String compress(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1;i < str.length();i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                count++;
            } else {
                result.append(str.charAt(i-1));
                if (count != 1) result.append(Integer.toString(count));
                count = 1;
            }
        }

        result.append(str.charAt(str.length()-1));
        if (count != 1) result.append(Integer.toString(count));

        return result.toString();
    }

    public static TreeNode insert(TreeNode root,int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) {
            root.left =  insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean validParenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch:str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } 
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParenthesis("()()((())())"));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public static void BFS(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0;i < size;i++) {
                TreeNode curr = q.remove();

                System.out.print(curr.val + " ");

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            System.out.println();
        }
    }
}