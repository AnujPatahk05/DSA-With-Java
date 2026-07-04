/*
    151. Reverse Words in a String
    (Medium)

    Given an input string s, reverse the order of the words.

    A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

    Return a string of the words in reverse order concatenated by a single space.

    Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single 
    space separating the words. Do not include any extra spaces.

    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"

    Example 2:
    Input: s = "  hello world  "
    Output: "world hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.
*/

public class _12_ReverseWordsInaString {
    // Using split method
    // TC: O(n)
    // SC: O(n)
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

    // Manual traversal
    // TC: O(n)
    // SC: O(n)
    public static String reverseWords2(String s){
        StringBuilder result = new StringBuilder();
        s = s.trim();
        int end = s.length();
        for(int i = s.length()-1;i >= 0;i--){
            char ch = s.charAt(i);

            if(ch == ' ' || i == 0){
                if(i > 0 && s.charAt(i-1) == ' ') continue;
                
                if(end != s.length()) result.append(" ");
                result.append(s.substring(i == 0? i:i+1,end));
                end = i;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence1 = "the sky is blue";
        System.out.println(reverseWords(sentence1));

        String sentence2 = "  hello world  ";
        System.out.println(reverseWords(sentence2));

        String sentence3 = "a good   example";
        System.out.println(reverseWords(sentence3));

        
    }

}
