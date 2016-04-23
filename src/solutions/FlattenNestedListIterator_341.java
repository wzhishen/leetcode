package solutions;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import datastructure.NestedInteger;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also
 * be integers or other lists.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, the order of
 * elements returned by next should be: [1,1,2,1,1].
 *
 * Example 2:
 * Given the list [1,[4,[6]]],
 * By calling next repeatedly until hasNext returns false, the order of
 * elements returned by next should be: [1,4,6].
 */
public class FlattenNestedListIterator_341 {

    public class NestedIterator implements Iterator<Integer> {
        private Stack<NestedInteger> s;
        private NestedInteger p;

        public NestedIterator(List<NestedInteger> nestedList) {
            s = new Stack<NestedInteger>();
            push(nestedList);
        }

        @Override
        public Integer next() {
            return p.getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!s.isEmpty()) {
                p = s.pop();
                if (p.isInteger()) return true;
                else push(p.getList());
            }
            return false;
        }

        private void push(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; --i) s.push(nestedList.get(i));
        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
