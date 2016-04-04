package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you
 * have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is
 * it possible for you to finish all courses?
 *
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0, and to take course 0 you should also have finished
 * course 1. So it is impossible.
 *
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 *
 * Hints:
 * 1. This problem is equivalent to finding if a cycle exists in a directed
 * graph. If a cycle exists, no topological ordering exists and therefore it
 * will be impossible to take all 
 * 2. Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * 3. Topological sort could also be done via BFS.
 */
public class CourseSchedule_207 {
    /* Topological Sort
     * Reference:
     * https://en.wikipedia.org/wiki/Topological_sorting
     * http://www.cnblogs.com/grandyang/p/4484571.html
     */
    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return false;
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
        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            ++cnt;
            if (graph.containsKey(curr)) {
                for (int next : graph.get(curr)) {
                    --indegrees[next]; // "remove" edge
                    if (indegrees[next] == 0) q.add(next);
                }
            }
        }
        return cnt == numCourses;
    }

    // DFS
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return false;
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numCourses; ++i) graph.put(i, new ArrayList<Integer>());
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);

        int[] visited = new int[numCourses];
        for (int n : graph.keySet()) {
            if (!canFinish(graph, visited, n)) return false;
        }
        return true;
    }

    private boolean canFinish(HashMap<Integer, List<Integer>> graph, int[] visited, int n) {
        if (visited[n] == -1) return false;
        if (visited[n] == 1) return true;
        visited[n] = -1;
        if (graph.containsKey(n)) {
            for (int next : graph.get(n)) {
                if (!canFinish(graph, visited, next)) return false;
            }
        }
        visited[n] = 1;
        return true;
    }
}
