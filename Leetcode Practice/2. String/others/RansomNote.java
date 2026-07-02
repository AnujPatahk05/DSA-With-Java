/*
    383. Ransom Note
    (easy)

    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the 
    letters from magazine and false otherwise.

    Each letter in magazine can only be used once in ransomNote.

    Example 1:
    Input: ransomNote = "a", magazine = "b"
    Output: false

    Example 2:
    Input: ransomNote = "aa", magazine = "ab"
    Output: false

    Example 3:
    Input: ransomNote = "aa", magazine = "aab"
    Output: true
 */

import java.util.HashMap;

public class RansomNote {

    // Solution using HashMap
    // TC: O(m+n)
    // SC: O(k) , where k is the number of distinct characters (at most 26 for lowercase English letters).
    // k is fixed to 26 so we can say: 
    // SC: O(1)
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    // Solution using a fixed size = 26 array
    // TC: O(m + n)
    // SC: O(1) -> because array size is fixed
    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch: ransomNote.toCharArray()) {
            freq[ch - 'a']--;
            if(freq[ch - 'a'] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));

        System.out.println(canConstruct2("a", "b"));
        System.out.println(canConstruct2("aa", "ab"));
        System.out.println(canConstruct2("aa", "aab"));
    }
}
