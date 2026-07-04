/*
    443. String Compression
    (Medium)

    Given an array of characters chars, compress it using the following algorithm:

    Begin with an empty string s. For each group of consecutive repeating characters in chars:

    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
    The compressed string s should not be returned separately, but instead, be stored in the input character array chars. 
    Note that group lengths that are 10 or longer will be split into multiple characters in chars.

    After you are done modifying the input array, return the new length of the array.

    You must write an algorithm that uses only constant extra space.

    Note: The characters in the array beyond the returned length do not matter and should be ignored.

    Example 1:

    Input: chars = ["a","a","b","b","c","c","c"]
    Output: 6
    Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
    After modifying the input array in-place, the first 6 characters of chars should be ["a","2","b","2","c","3"].
*/

public class _6_StringCompression {

    // Using StringBuilder
    // TC: O(n)
    // SC: O(n)
    public static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                continue;
            }

            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                sb.append(chars[i - 1]);
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }

        sb.append(chars[chars.length - 1]);
        if (count > 1) {
            sb.append(count);
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }

    // TC: O(log10(count))
    private static int update(char[] chars,char al,int idx,int count){
        chars[idx++] = al;

        if(count <= 1) return idx;

        for(char ch: String.valueOf(count).toCharArray()) {
            chars[idx++] = ch;
        }
        
        return idx;
    }

    // Optimal solution : In place using 2 pointer: i and idx
    // TC: O(n)
    // SC: O(1)
    public static int compress2(char[] chars) {
        int idx = 0;

        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                continue;
            }

            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                idx = update(chars, chars[i - 1],idx, count);
                count = 1;
            }
        }

        idx = update(chars,chars[chars.length - 1], idx, count);

        return idx;
    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c'};
        System.out.println("count: "+compress2(chars1));
        for (char ch : chars1) {
            System.out.print(ch);
        }

        System.out.println();

        char[] chars2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println("count: "+compress2(chars2));
        for (char ch: chars2) {
            System.out.print(ch);
        }
    }
}
