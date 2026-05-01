import java.util.Stack;

public class _9_DuplicateParentheses {
    public static boolean isDuplicateParentheses(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            if(ch != ')'){
                stack.push(ch);
            }else{
                int count = 0;
                while(stack.pop() != '(')count++;
                if(count<1)return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        // System.out.println(isDuplicateParentheses("(((a+(b)))+(c+d))"));
        System.out.println(isDuplicateParentheses("((a+b)+b+c+d)(a-b+((c+d)))"));
        System.out.println(isDuplicateParentheses("((c+d))"));

    }
}
