package solutions;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * Notes:
 * 1. You must use only standard operations of a queue -- which means only
 * push to back, peek/pop from front, size, and is empty operations are valid.
 * 2. Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 * 3. You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 */
public class ImplementStackUsingQueues_225 {
    LinkedList<Integer> q = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; ++i) q.add(q.remove());
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.remove();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
