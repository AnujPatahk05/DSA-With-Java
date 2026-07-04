

/*
    58. Length of Last Word
    (easy)

    Given a string s consisting of words and spaces, 
    return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.

    Example:

    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.
*/

public class LengthofLastWord {
    // TC: O(n)
    // SC: O(n) due to s.trim() because it creates a new String
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        for(int i = s.length()-1;i >= 0;i--) {
            if(s.charAt(i) == ' ') break;
            count++;
        }
        return count;
    }

    // TC: O(n)
    // SC: O(1)
    public static int lengthOfLastWord2(String s) {
        int count = 0;
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }

        while(i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }

    public static void main(String[] args) {
        String input1 = "Hello World";
        System.out.println(lengthOfLastWord(input1));

        String input2 = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(input2));
    }
}
