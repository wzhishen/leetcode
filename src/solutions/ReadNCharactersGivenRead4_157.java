package solutions;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4/
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example,
 * it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 *
 * Note:
 * The read function will only be called once for each test case.
 */
public class ReadNCharactersGivenRead4_157 /* extends Reader4 */ {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    /* Key:
     * 1. if not EOF: copy full len (4) or remaining len (n - i)?
     * 2. if EOF: copy full actual len (resLen) or remaining len (n - i)?
     */
    public int read(char[] buf, int n) {
        if (buf == null || n <= 0) return 0;

        char[] res = new char[4];
        for (int i = 0; i < n; i += 4) {
            int resLen = read4(res);
            int len = Math.min(resLen, n - i);
            for (int k = 0; k < len; ++k) buf[i + k] = res[k];
            // reach EOF
            if (resLen < 4) return i + len;
        }
        return n;
    }

    /* in class Reader4 */
    private int read4(char[] buf) {
        return 0; // not implemented
    }
}
