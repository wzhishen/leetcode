package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack_155 {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        if (stack.isEmpty() || x <= getMin()) min.push(x);
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (x == getMin()) min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
