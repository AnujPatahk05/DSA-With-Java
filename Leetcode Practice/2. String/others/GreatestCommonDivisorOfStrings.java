
public class GreatestCommonDivisorOfStrings {
    private static boolean divides(String s1,String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1%l2 != 0 || l2 > l1) return false;
        
        int i = 0;
        while (i < l1) {
            for (int j = 0;j < l2;j++) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    return false;
                }
                i++;
            }
        }

        return true;
    }

    
    public static String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < l1 && i < l2) {
            if(str1.charAt(i) == str2.charAt(i)) {
                result.append(str1.charAt(i));
            } else {
                break;
            }
            i++;
        }

        if (result.length() == 0) {
            return result.toString();
        }

        while (result.length() > 0) {
            if (l1%result.length() != 0 || l2%result.length() != 0) {
                result.deleteCharAt(result.length()-1);
            }

            if (divides(str1,result.toString()) && divides(str2, result.toString())) {
                return result.toString();
            } else {
                result.deleteCharAt(result.length()-1);
            }

        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }
}
