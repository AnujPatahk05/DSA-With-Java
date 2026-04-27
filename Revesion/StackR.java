
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

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);

        

    }
}
