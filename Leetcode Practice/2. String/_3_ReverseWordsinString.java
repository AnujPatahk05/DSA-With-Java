/*
    1910. Remove All Occurrences of a Substring

    Given two strings s and part, perform the following operation on s until all 
    occurrences of the substring part are removed:

    Find the leftmost occurrence of the substring part and remove it from s.
    Return s after removing all occurrences of part.

    A substring is a contiguous sequence of characters in a string.

    Example 1:

    Input: s = "daabcbaabcbc", part = "abc"
    Output: "dab"
    Explanation: The following operations are done:
    - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
    - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
    - s = "dababc", remove "abc" starting at index 3, so s = "dab".
    Now s has no occurrences of "abc".
*/

public class _3_ReverseWordsinString {

    //Using split method TC: O(n)
    //                   SC: O(n)
    public static String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = words.length-1;i >= 0;i--){
            if(words[i].length() > 0){
                if(i != words.length-1) result.append(" ");
                result.append(words[i]);
            }
        }

        return result.toString();
    }

    //Using two pointer TC: O(n)
    //                  SC: O(n)
    public static String reverseWords2(String s){
        StringBuilder result = new StringBuilder();
        s = s.trim();
        int end = s.length();
        for(int i = s.length()-1;i >= 0;i--){
            char ch = s.charAt(i);

            if(ch == ' ' || i == 0){
                if(i > 0 && s.charAt(i-1) == ' '){
                    continue;
                }
                if(end != s.length()) result.append(" ");
                result.append(s.substring(i == 0? i:i+1,end).trim());
                end = i;
            }
        }

        return result.toString();
        
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";

        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
        System.out.println(reverseWords(s3));

        System.out.println("-----");

        System.out.println(reverseWords2(s1));
        System.out.println(reverseWords2(s2));
        System.out.println(reverseWords2(s3));

    }
}
