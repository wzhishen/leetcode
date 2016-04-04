package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/
 *
 * Given a string that contains only digits 0-9 and a target value, return
 * all possibilities to add binary operators (not unary) +, -, or * between
 * the digits so they evaluate to the target value.
 *
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 */
public class ExpressionAddOperators_282 {
    // Ref: https://segmentfault.com/a/1190000003797204
    public List<String> addOperators(String num, int target) {
        List<String> solutions = new ArrayList<String>();
        if (num == null) return solutions;
        addOperators(num, target, 0, "", solutions, 0, 0);
        return solutions;
    }

    private void addOperators(String num, int target, int index, String path, List<String> solutions, long sum, long prev) {
        if (index == num.length() && sum == target) {
            solutions.add(path);
        } else {
            for (int i = index; i < num.length(); ++i) {
                // invalidate cases with leading 0s like "0012"
                if (num.charAt(index) == '0' && i > index) return;

                String currStr = num.substring(index, i + 1);
                long currNum = Long.parseLong(currStr);
                if (path.isEmpty()) {
                    addOperators(num, target, i + 1, currStr, solutions, currNum, currNum);
                } else {
                    addOperators(num, target, i + 1, path + "+" + currStr, solutions, sum + currNum, currNum);
                    addOperators(num, target, i + 1, path + "-" + currStr, solutions, sum - currNum, -currNum);
                    addOperators(num, target, i + 1, path + "*" + currStr, solutions, sum - prev + prev * currNum, prev * currNum);
                }
            }
        }
    }
}
