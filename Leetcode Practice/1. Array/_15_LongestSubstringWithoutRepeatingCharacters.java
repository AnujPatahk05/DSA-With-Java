/*
    3. Longest Substring Without Repeating Characters
    (Medium)

    Given a string s, find the length of the longest substring without duplicate characters.

    Example:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

*/


import java.util.HashMap;

public class _15_LongestSubstringWithoutRepeatingCharacters {
    // Optimal Solution: TC: O(n)
    //                   SC: O(n)
    public static int lengthOfLongestSubstring(String s){
        HashMap<Character,Integer> map = new HashMap<>();

        int start = 0;
        int max = 0;

        for(int end = 0;end < s.length();end++){
            char ch = s.charAt(end);

            if(map.containsKey(ch)){
                start = Math.max(start,map.get(ch)+1);
            }

            map.put(ch, end);
            max = Math.max(max,end-start+1);
        }

        return max;
    }

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";

        System.out.println(lengthOfLongestSubstring(str1));
        System.out.println(lengthOfLongestSubstring(str2));
    }
}
