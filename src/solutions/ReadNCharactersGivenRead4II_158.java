package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example,
 * it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 *
 * Note:
 * The read function may be called multiple times.
 */
public class ReadNCharactersGivenRead4II_158 /* extends Reader4 */ {
    Queue<Character> q = new LinkedList<Character>();

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    /* Key: copy any remaining chars to a queue from current read,
     * read these chars from the queue first upon next read.
     */
    public int read(char[] buf, int n) {
        if (buf == null || n <= 0) return 0;

        // read any remaining chars from last read
        int i = 0;
        while (!q.isEmpty() && i < n) {
            buf[i++] = q.remove();
        }

        char[] res = new char[4];
        for (; i < n; i += 4) {
            int resLen = read4(res);
            int len = Math.min(resLen, n - i);
            // normal copy
            copy(buf, res, i, 0, len);

            // buffer any remaining chars to a queue so won't miss them upon next read
            if (len == n - i) {
                for (int k = n - i; k < resLen; ++k) q.add(res[k]);
            }

            // reach EOF
            if (resLen < 4) return i + len;
        }
        return n;
    }

    private void copy(char[] des, char[] src, int i, int j, int len) {
        for (int k = 0; k < len; ++k) des[i + k] = src[j + k];
    }

    /* in class Reader4 */
    private int read4(char[] buf) {
        return 0; // not implemented
    }
}
