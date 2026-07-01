/*
    290. Word Pattern
    (easy)

    Given a pattern and a string s, find if s follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern 
    and a non-empty word in s. Specifically:

    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.
    

    Example:

    Input: pattern = "abba", s = "dog cat cat dog"
    Output: true

    Explanation:

    The bijection can be established as:
    'a' maps to "dog".
    'b' maps to "cat".
*/

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    // Solution using Split + HashMap + HashSet 
    // TC: O(n)
    // SC: O(n)
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        String[] words = s.split(" ");

        if(words.length != pattern.length()) return false;

        for(int i = 0;i < words.length;i++) {
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)) {
                if(!words[i].equals(map.get(ch))) return false;
            } else {
                if(set.contains(words[i])) return false;
                set.add(words[i]);
                map.put(ch,words[i]);
            }
        }

        return true;
    }

    // Solution using HashMap + HashSet 
    // Manually parsing the string instead of using split()
    // TC: O(n)
    // SC: O(n)
    public static boolean wordPattern2(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        int start = 0;
        for(int i = 0;i < pattern.length();i++) {
            if(start >= s.length()) return false;

            char ch = pattern.charAt(i);
            int end = start;

            while(end < s.length() &&  s.charAt(end) != ' ') {
                end++;
            }

            String p = s.substring(start,end);
            start = end + 1;

            if(map.containsKey(ch)) {
                if(!p.equals(map.get(ch))) return false;
            } else {
                if(set.contains(p)) return false;
                set.add(p);
                map.put(ch,p);
            } 
        }

        if (start < s.length()) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));

        System.out.println();
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }
}