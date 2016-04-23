package solutions;

import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-2d-vector/
 *
 * Implement an iterator to flatten a 2d vector.
 *
 * For example,
 * Given 2d vector =
 * [
 *   [1,2],
 *   [3],
 *   [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,2,3,4,5,6].
 *
 * Hint:
 * 1. How many variables do you need to keep track?
 * 2. Two variables is all you need. Try with x and y.
 * 3. Beware of empty rows. It could be the first few rows.
 * 4. To write correct code, think about the invariant to maintain. What is it?
 * 5. The invariant is x and y must always point to a valid point in the 2d vector.
 * Should you maintain your invariant ahead of time or right when you need it?
 * 6. Not sure? Think about how you would implement hasNext(). Which is more complex?
 * 7. Common logic in two different places should be refactored into a common method.
 *
 * Follow up:
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Flatten2DVector_251 {

    public class Vector2D_2 implements Iterator<Integer> {
        private int i = 0, j = 0;
        private List<List<Integer>> vec2d;

        public Vector2D_2(List<List<Integer>> vec2d) {
            if (vec2d == null) return;
            this.vec2d = vec2d;
        }

        @Override
        public Integer next() {
            int val = vec2d.get(i).get(j);
            ++j;
            if (j == vec2d.get(i).size()) {
                j = 0;
                ++i;
            }
            return val;
        }

        @Override
        public boolean hasNext() {
            while (i < vec2d.size() && vec2d.get(i).isEmpty()) {
                ++i; j = 0;
            }
            return i < vec2d.size() && j < vec2d.get(i).size();
        }
    }

    // Follow up
    public class Vector2D implements Iterator<Integer> {
        private Iterator<List<Integer>> iter;
        private Iterator<Integer> curr;

        public Vector2D(List<List<Integer>> vec2d) {
            if (vec2d == null) return;
            iter = vec2d.iterator();
        }

        @Override
        public Integer next() {
            return curr.next();
        }

        @Override
        public boolean hasNext() {
            while (iter.hasNext() && (curr == null || !curr.hasNext())) {
                curr = iter.next().iterator();
            }
            return curr != null && curr.hasNext();
        }
    }

    /**
     * Your Vector2D object will be instantiated and called as such:
     * Vector2D i = new Vector2D(vec2d);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
