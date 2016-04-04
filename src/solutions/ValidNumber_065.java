package solutions;

public class ValidNumber_065 {
    /* Ref:
     * http://www.yanyulin.info/pages/2014/10/38958011441714.html
     * http://www.jiuzhang.com/solutions/valid-number/
     *
     * Other thoughts:
     * Regex: http://blog.csdn.net/fightforyourdream/article/details/12900751
     * Finite state machine: http://blog.csdn.net/kenden23/article/details/18696083
     */
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();

        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            // valid num
            if (ch >= '0' && ch <= '9') {
                num = true;
            // valid '.': no prev '.', no prev 'e'
            } else if (ch == '.') {
                if (dot || exp) return false;
                dot = true;
            // valid 'e': no prev 'e', prev num and following num
            } else if (ch == 'e') {
                if (exp || !num) return false;
                exp = true;
                num = false;
            // valid +/-: leading +/-, or e+/-
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            // invalid char
            } else {
                return false;
            }
        }
        return num;
    }
}
