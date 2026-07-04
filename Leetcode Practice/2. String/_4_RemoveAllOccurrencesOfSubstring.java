/*
    1910. Remove All Occurrences of a Substring
    (Medium)

    Given two strings s and part, perform the following operation on s until all occurrences of the substring 
    part are removed:

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

public class _4_RemoveAllOccurrencesOfSubstring {
    // TC: O(n^2 * m) 
    //      n -> s.length()
    //      m -> part.length()
    // SC: O(n)
    public static String removeOccurrences(String s, String part) {
        int index = s.indexOf(part);
        while(index != -1) {
            s = s.substring(0,index) + s.substring(index+part.length());

            index = s.indexOf(part);
        }
        
        return s;
    }

    // TC: O(n^2 * m) 
    //      n -> s.length()
    //      m -> part.length()
    // SC: O(n)

    // But it is more efficient because we do not need to start from begning(indexof())
    public static String removeOccurrences2(String s, String part) {
        StringBuilder result = new StringBuilder();

        for(char ch: s.toCharArray()) {
            result.append(ch);

            if(result.length() >= part.length()) {
                int start = result.length() - part.length();

                if(result.substring(start).equals(part)) {
                    result.delete(start, result.length());
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences2("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrences2("axxxxyyyyb", "xy"));
    }
}
