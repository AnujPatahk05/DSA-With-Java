/*
    205. Isomorphic Strings
    (easy)

    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters
    may map to the same character, but a character may map to itself.

    

    Example 1:
    Input: s = "egg", t = "add"
    Output: true
    Explanation:
    The strings s and t can be made identical by:
    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

    Example 2:
    Input: s = "f11", t = "b23"
    Output: false
    Explanation:
    The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

    Example 3:
    Input: s = "paper", t = "title"
    Output: true
*/

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    /*  
        Use a HashMap to maintain the character mapping from s to t and a HashSet to 
        ensure that no two characters in s map to the same character in t (one-to-one mapping).
    */
    // TC: O(n)
    // SC: O(n)
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0;i < s.length();i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map.containsKey(ch1)) {
                if(map.get(ch1) != ch2) return false;
            } else {
                if(set.contains(ch2)) return false;
                map.put(ch1,ch2);
                set.add(ch2);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String t1 = "aa";
        System.out.println(isIsomorphic(s1, t1));
    }
}