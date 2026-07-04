/*
    49. Group Anagrams
    (medium)

    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    Example :

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Explanation:
    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _8_GroupAnagrams {
    // TC: O(s1.length()) -> O(n)
    // SC: O(26) -> O(1)
    private static boolean isAnagrams(String s1,String s2) {
        if(s1.length() != s2.length()) return false;

        int[] freq = new int[26];

        for(char ch:s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch:s2.toCharArray()) {
            if(--freq[ch - 'a'] < 0) return false;
        }

        return true;
    }

    // Brute force solution
    // TC: O(n^2 * k) -> k: avg length of each string

    // SC: O(n) -> because of taken[]
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] taken = new boolean[strs.length];

        for(int i = 0;i < strs.length;i++) {
            if(!taken[i]) {
                List<String> ans = new ArrayList<>();
                ans.add(strs[i]);
                taken[i] = true;

                for(int j = 0; j < strs.length;j++) {
                    if(i == j || taken[j]) continue;

                    if(isAnagrams(strs[i], strs[j])) {
                        ans.add(strs[j]);
                        taken[j] = true;
                    }
                }
                
                result.add(ans);
            }
        }

        return result;
    }

    // TC: O(n log n) -> n: str.length()
    private static String getKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // TC: O(n* k log k) 
    //      n -> str.length (number of strings)
    //      k -> average string length
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str:strs) {
            String key = getKey(str);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
   

    public static void main(String[] args) {
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams2(strs1));

        String[] strs2 = {""};
        System.out.println(groupAnagrams2(strs2));

        String[] strs3 = {"a"};
        System.out.println(groupAnagrams2(strs3));

        String[] strs4 = {"ac","c"};
        System.out.println(groupAnagrams2(strs4));
    }
}
