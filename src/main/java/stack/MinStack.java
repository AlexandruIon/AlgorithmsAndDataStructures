package stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty()) {
            min.push(val);
        }
        else if (min.peek() >= val) {
            min.push(val);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int pop() {
        if (stack.peek().equals(min.peek())) {
            min.pop();
        }
        return stack.pop();
    }

    public int getMin() {
        return min.peek();
    }

}
