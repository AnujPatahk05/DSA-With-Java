/*
    14. Longest Common Prefix
    (easy)

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
*/

public class _7_LongestCommonPrefix {
    // TC: O(n*m) 
    //      n -> no of strings
    //      m -> length of the shortest string
    // SC: O(1)
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1;i < strs.length;i++){
            if(strs[i].isEmpty()) return "";
            for(int j = 0;j < prefix.length() && j < strs[i].length();j++){
                if(prefix.charAt(j) == strs[i].charAt(j)){
                    if(j == strs[i].length()-1) prefix = strs[i].substring(0,j+1);
                }else{
                    prefix = strs[i].substring(0,j);
                    break;
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

}
