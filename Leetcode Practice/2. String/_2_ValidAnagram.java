/*
    242. Valid Anagram
    (easy)
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    Anagram:
    An anagram is a word or phrase formed by rearranging the letters of a different word or
    phrase, using all the original letters exactly once.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true
*/

import java.util.HashMap;

public class _2_ValidAnagram {

    //Using HashMap TC: O(m+n)
    //              SC: O(1) because map can be of max size 26
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }

        System.out.println(map);

        for(int i = 0;i < t.length();i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }

        return map.isEmpty();
    }

    

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

        String p = "rat"; // r:1 , a:1 , t:1
        String q = "car";
        System.out.println(isAnagram(p,q));
    }
}
