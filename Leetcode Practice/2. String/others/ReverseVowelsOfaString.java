/*
    345. Reverse Vowels of a String
    (easy)

    Given a string s, reverse only all the vowels in the string and return it.
    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

    Example 1:
    Input: s = "IceCreAm"
    Output: "AceCreIm"
    Explanation:
    The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

    Example 2:
    Input: s = "leetcode"
    Output: "leotcede"
*/

import java.util.Stack;

public class ReverseVowelsOfaString {
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'|| 
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    // Two Pointer Approach
    // TC: O(n)
    // SC: O(n)
    public static String reverseVowels(String s) {
        char chars[] = s.toCharArray();

        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if(isVowel(chars[i]) && isVowel(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;

                i++;
                j--;
            } else if(isVowel(chars[i])) {
                j--;
            } else if(isVowel(chars[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return String.valueOf(chars);
    }

    // Stack and StringBuilder approach
    // TC: O(n)
    // SC: O(n)
    public static String reverseVowels2(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder("");

        for(char ch: s.toCharArray()) {
            if(isVowel(ch)) stack.push(ch);
        }

        for(char ch: s.toCharArray()) {
            result.append(isVowel(ch) ? stack.pop() : ch);
        }

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseVowels2("IceCreAm"));// AceCreIm
        System.out.println(reverseVowels2("leetcode"));// leotcede
    }
}
