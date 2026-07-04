/*
    567. Permutation in String
    (Medium)

    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.

    Example 1:
    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:
    Input: s1 = "ab", s2 = "eidboaoo"
    Output: false
 
*/


import java.util.ArrayList;
import java.util.List;

public class _5_PermutationInString {
    // Finding all permutations using backtracking
    // TC: O(n*n!)
    // SC: O(n)
    private static void permutations(String s,String permutation,boolean[] used,List<String> permutations) {
        if(permutation.length() == s.length()) {
            permutations.add(permutation);
            return;
        }

        for(int i = 0;i < s.length();i++) {
            if(!used[i]) {
                used[i] = true;
                permutations(s, permutation + s.charAt(i), used, permutations);
                used[i] = false;
            }
        }
    }

    // Brute force approach
    // TC: O(n*m!)
    // SC: O(m*m!)
    public static boolean checkInclusion(String s1, String s2) {
        List<String> permutations = new ArrayList<>();
        permutations(s1, "", new boolean[s1.length()], permutations);

        for(String permutation:permutations) {
            if(s2.contains(permutation)) {
                return true;
            }
        }

        return false;
    }

    // TC: O(n)
    private static boolean isPermutation(String s1,String s2) {
        int freq[] = new int[26];

        for(char ch:s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch:s2.toCharArray()) {
            if(--freq[ch - 'a'] < 0) return false;
        }

        return true;
    }

    // Intermediate optimal solution : sliding window + check every window seperately 
    // TC: O(nm)
    // SC: O(1)
    public static boolean checkInclusion2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        for(int start = 0;start < n - m + 1;start++) {
            int end = start + m;

            if(isPermutation(s2.substring(start,end), s1)) {
                return true;
            }
        }

        return false;
    }

    // TC: O(26) -> O(1)
    private static boolean matches(int[] freq1,int[] freq2) {
        for(int i = 0;i < freq1.length;i++) {
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }

    // Optimal Solution: Sliding window + 
    // TC: O(n)
    // SC: O(1)
    public static boolean checkInclusion3(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int freqS1[] = new int[26];
        int freqWindow[] = new int[26];

        for(char ch:s1.toCharArray()) {
            freqS1[ch - 'a']++;
        }

        for(int i = 0;i < s2.length();i++) {
            char ch = s2.charAt(i);

            freqWindow[ch - 'a']++;

            if(i - m >= 0) {
                freqWindow[s2.charAt(i-m) - 'a']--;
            }

            if(i >= m-1 && matches(freqS1, freqWindow)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion3("ab", "eidbaooo"));
        System.out.println(checkInclusion3("ab", "eidboaoo"));
    }
}
