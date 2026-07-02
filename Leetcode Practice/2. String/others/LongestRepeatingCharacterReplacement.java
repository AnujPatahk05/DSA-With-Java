/*
    424. Longest Repeating Character Replacement
    (Medium)

    You are given a string s and an integer k. You can choose any character of the string and change it to 
    any other uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the 
    above operations.

    Example 1:

    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

    Example 2:
    
    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exists other ways to achieve this answer too.
*/

public class LongestRepeatingCharacterReplacement {
    // Brute force approach
    // TC: O(n^3) -> outer loop * inner loop * substring
    // SC: O(1) if ignore substrings
    // SC: O(n) if include them
    public static int characterReplacement(String s, int k) {
        int max = k;
        for(int i = 0;i < s.length();i++) {
            int[] freq = new int[26];

            for(int j = i;j < i+k && j < s.length();j++) {
                char ch = s.charAt(j);
                freq[ch-'A']++;
            }

            for(int j = i+k;j < s.length();j++) {
                char ch = s.charAt(j);
                freq[ch-'A']++;

                String subString = s.substring(i,j+1);

                for(int c = 'A';c <= 'Z';c++) {
                    if(freq[c-'A'] >= subString.length() - k) max = Math.max(max,subString.length());
                }
            }
        }

        return max;
    }

    // Improved brute force
    // TC: O(n^2) -> outer*inner loop
    // SC: O(1)
    public static int characterReplacement2(String s, int k) {
        int max = k;
        for(int i = 0;i < s.length();i++) {
            int[] freq = new int[26];

            for(int j = i;j < i+k && j < s.length();j++) {
                char ch = s.charAt(j);
                freq[ch-'A']++;
            }

            for(int j = i+k;j < s.length();j++) {
                char ch = s.charAt(j);
                freq[ch-'A']++;

                int subStringLength = j - i + 1;

                for(int c = 'A';c <= 'Z';c++) {
                    if(freq[c-'A'] >= subStringLength - k) max = Math.max(max,subStringLength);
                }
            }
        }

        return max;
    }

    // Optimal Solution: 
    // Sliding window + freq array + track maxFreq per window
    // TC: O(n)
    // SC: O(1)
    public static int characterReplacement3(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int right = 0;

        int maxFreq = 0;
        int maxLen = 0;

        while(right < s.length()) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq,freq[ch - 'A']);

            while((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                maxFreq = 0;
                for(int i = 0;i < 26;i++) {
                    maxFreq = Math.max(maxFreq,freq[i]);
                }
            }

            maxLen = Math.max(maxLen,right - left + 1);

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement3("ABAB", 2));
        System.out.println(characterReplacement3("AABABBA", 1));
    }
}
