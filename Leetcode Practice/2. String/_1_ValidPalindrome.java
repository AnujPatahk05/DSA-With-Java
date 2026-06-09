/*
    125. Valid Palindrome
    (easy) --> https://dsa.apnacollege.in/

    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and 
    removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric 
    characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
*/

public class _1_ValidPalindrome {
    // TC: O(n)
    // SC: O(1)
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i < j){
            char ch1 = Character.toLowerCase(s.charAt(i));
            char ch2 = Character.toLowerCase(s.charAt(j));

            // while(i < j && ch1 < '0' || (ch1 > '9' && ch1 < 'a') || ch1 > 'z'){
            //     i++;
            //     ch1 = Character.toLowerCase(s.charAt(i));
            // }

            // while(i < j && ch2 < '0' || (ch2 > '9' && ch2 < 'a') || ch2 > 'z'){
            //     j--;
            //     ch2 = Character.toLowerCase(s.charAt(j));
            // }

            while(i < j && !Character.isLetterOrDigit(ch1)){
                i++;
                ch1 = Character.toLowerCase(s.charAt(i));
            }

            while(i < j && !Character.isLetterOrDigit(ch2)){
                j--;
                ch2 = Character.toLowerCase(s.charAt(j));
            }


            if(ch1 != ch2){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] a){
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "0P0##%0P0";
        String s3 = "race a car";
        System.out.println(isPalindrome(s1));
    }
}
