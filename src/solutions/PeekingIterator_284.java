package solutions;

import java.util.Iterator;

/**
 * https://leetcode.com/problems/peeking-iterator/
 *
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 *
 * Here is an example. Assume that the iterator is initialized to the beginning
 * of the list: [1, 2, 3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2.
 * You call next() the final time and it returns 3, the last element. Calling
 * hasNext() after that should return false.
 *
 * Hint:
 * 1. Think of "looking ahead". You want to cache the next element.
 * 2. Is one variable sufficient? Why or why not?
 * 3. Test your design with call order of peek() before next() vs next() before
 * peek().
 *
 * Follow up: How would you extend your design to be generic and work with all
 * types, not just integer?
 */
public class PeekingIterator_284 {

    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iter;
        private boolean peeked;
        private Integer peekedValue;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!peeked) {
                peekedValue = iter.next();
                peeked = true;
            }
            return peekedValue;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peeked) {
                peeked = false;
                return peekedValue;
            }
            return iter.next();
        }

        @Override
        public boolean hasNext() {
            return peeked || iter.hasNext();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
