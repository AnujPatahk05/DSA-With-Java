/*
    76. Minimum Window Substring
    (hard)

    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t 
    (including duplicates) is included in the window. If there is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.

    

    Example 1:
    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    Example 2:
    Input: s = "a", t = "a"
    Output: "a"
    Explanation: The entire string s is the minimum window.
*/

public class _9_MinimumWindowSubstring {
    // TC: O(52) -> O(1)
    // SC: O(1)
    private static boolean includes(int[] t,int[] window) {
        for(char ch = 'a';ch <= 'z';ch++) {
            if(t[ch] > window[ch]) return false;
        }

        for(char ch = 'A';ch <= 'Z';ch++) {
            if(t[ch] > window[ch]) return false;
        }

        return true;
    }

    // Sliding window approach
    // TC: O(52 * n) -> O(n)
    // SC: O(128 + 128) -> O(1)
    public static String minWindow(String s, String t) {
        int[] freqT = new int[128];
        int[] freqWindow = new int[128];

        String result = "";

        for(char ch: t.toCharArray()) {
            freqT[ch]++;
        }

        int left = 0;

        for(int right = 0; right < s.length();right++) {
            char ch = s.charAt(right);
            freqWindow[ch]++;

            while(left <= right && includes(freqT, freqWindow)) {
                if(right - left + 1 < result.length() || result.length() == 0) {
                    result = s.substring(left,right+1);
                }

                freqWindow[s.charAt(left)]--;
                left++;
            }
        }

        return result;
    }

    // Sliding window approach
    // TC: O(n)
    // SC: O(n)
    public static String minWindow2(String s, String t) {
        int[] freqT = new int[128];
        int[] freqWindow = new int[128];

        String result = "";

        int required = 0;
        int formed = 0;

        for(char ch: t.toCharArray()) {
            freqT[ch]++;
            if(freqT[ch] == 1) required++;
        }

        int left = 0;

        for(int right = 0; right < s.length();right++) {
            char ch = s.charAt(right);
            freqWindow[ch]++;

            if(freqT[ch] > 0 && freqT[ch] == freqWindow[ch]) {
                formed++;
            }

            while(left <= right && required == formed) {
                if(right - left + 1 < result.length() || result.length() == 0) {
                    result = s.substring(left,right+1);
                }

                char leftChar = s.charAt(left);
                if(freqT[leftChar] > 0 && freqT[leftChar] == freqWindow[leftChar]) {
                    formed--;
                }

                freqWindow[s.charAt(left)]--;
                left++;
            }
        }

        return result;

        
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow2(s, t)); // BANC

        String s2 = "a";
        String t2 = "a";
        System.out.println(minWindow2(s2, t2)); // a

        String s3 = "a";
        String t3 = "aa";
        System.out.println(minWindow2(s3, t3)); // ""

        String s4 = "ab";
        String t4 = "b";
        System.out.println(minWindow2(s4, t4)); // b
    }
}
