
import java.util.Stack;

public class StackR {
    public static void pushAtBottom(Stack<Integer> stack,int value){
        if(stack.isEmpty()){
            stack.push(value);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, value);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int top = stack.pop();
        reverse(stack);
        pushAtBottom(stack, top);
    }

    public static void stockSpan(int[] stock,int[] span){
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);
    }

    public static int[] nextGreator(int[] arr){
        int[] nextGreator = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length-1;i > 0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }

            nextGreator[i] = stack.isEmpty() ? -1 : arr[stack.peek()];

            stack.push(i);
        }

        return nextGreator;
    }

    public static boolean validParenthesis(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);

            if(ch == '('  || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;

                if((stack.peek() == '(' && ch == ')' ) || (stack.peek() == '{' && ch == '}') || (stack.peek() == '[' && ch == ']'))
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean isDuplicateParentheses(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);

            if(ch != ')'){//(,a,b,c,+,-,*,/
                stack.push(ch);
            }else{
                int count = 0;
                while(stack.pop() != '(')count++;
                if(count < 1) return true;
            }
        }

        return false;
    }

    public static int maxAreaInHistogram(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[heights.length];

        for(int i = heights.length-1;i >= 0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            nextSmaller[i] = stack.isEmpty() ? heights.length : stack.peek();

            stack.push(i);
        }

        stack.clear();
        int[] prevSmaller = new int[heights.length];

        for(int i = 0;i < heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        int maxArea = Integer.MIN_VALUE;

        for(int i = 0;i < heights.length;i++){
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i]*width;
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }

    // private static int evalRPN(Stack<String> stack){
    //     String operator = stack.pop();

    //     int operand1;

    //     try{
    //         operand1 = Integer.parseInt(stack.peek());
    //         stack.pop();
    //     }catch(NumberFormatException e){
    //         operand1 = evalRPN(stack);
    //     }

    //     int operand2;

    //     try{
    //         operand2 = Integer.parseInt(stack.peek());
    //         stack.pop();
    //     }catch(NumberFormatException e){
    //         operand2 = evalRPN(stack);
    //     }
        
    //     if(operator.equals("+")){
    //         return operand2+operand1;
    //     }else if(operator.equals("-")){
    //         return operand2-operand1;
    //     }else if(operator.equals("*")){
    //         return operand2*operand1;
    //     }else{
    //         return operand2/operand1;
    //     }

    // }

    private static int top = 0;

    private static int evalRPN_Helper(String[] tokens){
        String token = tokens[top];
        top--;

        if(token.equals("+") || token.equals("-")  || token.equals("*")  || token.equals("/")){
            int operand1 = evalRPN_Helper(tokens);
            int operand2 = evalRPN_Helper(tokens);

            switch(token){
                case "+" : return operand2 + operand1;
                case "-" : return operand2 - operand1;
                case "*" : return operand2 * operand1;
                default: return operand2 / operand1;
            }
        }else{
            return Integer.parseInt(token);
        }
    }

    public static int evalRPN(String[] tokens){
        top = tokens.length-1;
        return evalRPN_Helper(tokens);
    }
    


    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
