/*
    844. Backspace String Compare
    (easy)

    Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

    Note that after backspacing an empty text, the text will continue empty.

    Example 1:
    Input: s = "ab#c", t = "ad#c"
    Output: true
    Explanation: Both s and t become "ac".

    Example 2:
    Input: s = "ab##", t = "c#d#"
    Output: true
    Explanation: Both s and t become "".

    Example 3:
    Input: s = "a#c", t = "b"
    Output: false
    Explanation: s becomes "c" while t becomes "b".
*/

public class BackspaceStringCompare {
    // String builder approach
    // TC: O(m + n)
    // SC: O(m + n)
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder s2 = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(ch == '#') {
                if(s2.length() == 0) continue;
                s2.deleteCharAt(s2.length()-1);
                continue;
            }
            s2.append(ch);
        }

        StringBuilder t2 = new StringBuilder();
        for(char ch: t.toCharArray()) {
            if(ch == '#') {
                if(t2.length() == 0) continue;
                t2.deleteCharAt(t2.length()-1);
                continue;
            }
            t2.append(ch);
        }

        return s2.toString().equals(t2.toString());
    }

    // String builder approach (More readable code, with seperate function to build strings after processing)
    // TC: O(m + n)
    // SC: O(m + n)

    private static String build(String str) {
        StringBuilder sb = new StringBuilder();

        for(char ch: str.toCharArray()) {
            if (ch == '#') {
                if (sb.length() > 0) sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static boolean backspaceCompare2(String s, String t) {
        return build(s).equals(build(t));
    }

    private static int removeBackspace(String s,int i) {
        if(i < 0) return -1;
        if(s.charAt(i) != '#') return i;

        int skip = 0;

        while(i >= 0) {
            if(s.charAt(i) == '#') {
                skip++;
                i--;
            } else if (skip > 0) {
                skip--;
                i--;
            } else break;
        }

        return i;
    }

    // 2 pointer approach
    public static boolean backspaceCompare3(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        
        while(i >= 0 || j >= 0) {
            i = removeBackspace(s, i);
            j = removeBackspace(t, j);

            if((i >= 0 && j >= 0 && 
              s.charAt(i) != t.charAt(j)) || (i >= 0 && j < 0) || (j >= 0 && i < 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
       
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare3("ab#c", "ad#c"));
        System.out.println(backspaceCompare3("ab##", "c#d#"));
        System.out.println(backspaceCompare3("a#c", "b"));


    }
}