/*
    387. First Unique Character in a String
    (easy)

    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

    Example 1:
    Input: s = "leetcode"
    Output: 0
    Explanation:
    The character 'l' at index 0 is the first character that does not occur at any other index.

    Example 2:
    Input: s = "loveleetcode"
    Output: 2

    Example 3:
    Input: s = "aabb"
    Output: -1
*/

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    // Using HashMap 
    // TC: O(n)
    // SC: O(1)
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch:s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1) return i;
        }

        return -1;
    }

    // Using fixed size array
    // TC: O(n)
    // SC: O(1)
    public static int firstUniqChar2(String s) {
        int[] freq = new int[26];

        for(char ch:s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i = 0;i < s.length();i++) {
            if(freq[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));

        System.out.println(firstUniqChar2("leetcode"));
        System.out.println(firstUniqChar2("loveleetcode"));
        System.out.println(firstUniqChar2("aabb"));
    }
}
