package solutions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-iterator/
 *
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 *
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of
 * elements returned by next should be: [1, 3, 2, 4, 5, 6].
 *
 * Follow up: What if you are given k 1d vectors? How well can your code
 * be extended to such cases?
 *
 * Clarification for the follow up question - Update (2015-09-18):
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2
 * cases. If "Zigzag" does not look right to you, replace "Zigzag" with
 * "Cyclic". For example, given the following input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * It should return [1,4,8,2,5,9,3,6,7].
 */
@SuppressWarnings("unchecked")
public class ZigzagIterator_281 {
    public class ZigzagIterator {
        private Iterator<Integer>[] iters;
        private int p = -1;

        public ZigzagIterator(List<Integer>... lists) {
            iters = new Iterator[lists.length];
            for (int i = 0; i < lists.length; ++i) {
                iters[i] = lists[i].iterator();
            }
        }

        public int next() {
            return iters[p].next();
        }

        public boolean hasNext() {
            inc();
            int old = p;
            while (!iters[p].hasNext()) {
                inc();
                if (p == old) return false;
            }
            return true;
        }

        private void inc() {
            p = (p + 1) % iters.length;
        }
    }

    // Ref: https://leetcode.com/discuss/58683/c-with-queue-compatible-with-k-vectors
    public class ZigzagIterator_2 {
        private LinkedList<Iterator<Integer>> iters;

        public ZigzagIterator_2(List<Integer>... lists) {
            iters = new LinkedList<Iterator<Integer>>();
            for (List<Integer> list : lists) {
                if (!list.isEmpty()) iters.add(list.iterator());
            }
        }

        public int next() {
            Iterator<Integer> p = iters.remove();
            int val = p.next();
            if (p.hasNext()) iters.add(p);
            return val;
        }

        public boolean hasNext() {
            return !iters.isEmpty();
        }
    }

    /**
     * Your ZigzagIterator object will be instantiated and called as such:
     * ZigzagIterator i = new ZigzagIterator(v1, v2);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
