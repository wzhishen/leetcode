public class Solution {
    // Divide two integers without using multiplication, division and mod operator.
    
    // math approach
    public int divide(int dividend, int divisor) {.
        /* a bunch of edge cases, particularly those regarding overflow */
        if (divisor == 0) throw new IllegalArgumentException();
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == 2) return dividend >> 1;
        if(dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE) return 0;
        boolean neg = dividend < 0 != divisor < 0;
        dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
        divisor = divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(divisor);
        int ret = (int) Math.pow(Math.E, (Math.log(dividend) - Math.log(divisor)));
        return neg ? -ret : ret;
    }
    // naive
    public int divideBF(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException();
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        boolean neg = dividend < 0 != divisor < 0;
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        int sum = 0;
        int cnt = 0;
        while (sum <= dividend) {
            sum += divisor;
            ++cnt;
        }
        return neg ? -cnt : cnt;
    }
}