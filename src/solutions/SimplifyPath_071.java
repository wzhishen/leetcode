package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath_071 {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) return "";
        String[] dirs = path.split("/");
        Stack<String> s = new Stack<String>();
        for (String dir : dirs) {
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!s.isEmpty()) s.pop();
            } else {
                s.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) sb.insert(0, s.pop()).insert(0, '/');
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
