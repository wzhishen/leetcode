package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So the correct course order is [0,1]
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have
 * finished both courses 1 and 2. Both courses 1 and 2 should be taken after
 * you finished course 0. So one correct course order is [0,1,2,3]. Another
 * correct ordering is[0,2,1,3].
 *
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 *
 * Hints:
 * This problem is equivalent to finding the topological order in a directed
 * graph. If a cycle exists, no topological ordering exists and therefore it
 * will be impossible to take all courses.
 * 2. Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * 3. Topological sort could also be done via BFS.
 */
public class CourseScheduleII_210 {
    /* Topological Sort
     * Reference:
     * https://en.wikipedia.org/wiki/Topological_sorting
     * http://www.cnblogs.com/grandyang/p/4484571.html
     */
    // BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return new int[0];
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] indegrees = new int[numCourses];
        // build adjacency list
        for (int i = 0; i < numCourses; ++i) graph.put(i, new ArrayList<Integer>());
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            ++indegrees[p[0]];
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegrees[i] == 0) q.add(i);
        }
        int[] result = new int[numCourses];
        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            result[cnt++] = curr;
            if (graph.containsKey(curr)) {
                for (int next : graph.get(curr)) {
                    --indegrees[next]; // "remove" edge
                    if (indegrees[next] == 0) q.add(next);
                }
            }
        }
        return cnt == numCourses ? result : new int[0];
    }

    // DFS
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return new int[0];
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numCourses; ++i) graph.put(i, new ArrayList<Integer>());
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);

        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<Integer>();
        for (int n : graph.keySet()) {
            if (!canFinish(graph, visited, n, res)) break;
        }

        if (res.size() != numCourses) return new int[0];
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) result[i] = res.get(i);
        return result;
    }

    private boolean canFinish(HashMap<Integer, List<Integer>> graph, int[] visited, int n, List<Integer> res) {
        if (visited[n] == -1) return false;
        if (visited[n] == 1) return true;
        visited[n] = -1;
        if (graph.containsKey(n)) {
            for (int next : graph.get(n)) {
                if (!canFinish(graph, visited, next, res)) return false;
            }
        }
        visited[n] = 1;
        res.add(0, n); // add to head
        return true;
    }
}
