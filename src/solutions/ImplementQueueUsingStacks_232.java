package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * Notes:
 * 1. You must use only standard operations of a stack -- which means only
 * push to top, peek/pop from top, size, and is empty operations are valid.
 * 2. Depending on your language, stack may not be supported natively. You
 * may simulate a stack by using a list or deque (double-ended queue), as
 * long as you use only standard operations of a stack.
 * 3.You may assume that all operations are valid (for example, no pop or
 * peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks_232 {
    private Stack<Integer> head = new Stack<Integer>();
    private Stack<Integer> tail = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        tail.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        head.pop();
    }

    // Get the front element.
    public int peek() {
        shift();
        return head.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }

    private void shift() {
        if (head.isEmpty()) {
            while(!tail.isEmpty()) head.push(tail.pop());
        }
    }
}
