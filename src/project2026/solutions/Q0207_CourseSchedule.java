package project2026.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/course-schedule/description/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

 */
public class Q0207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) graph.put(i, new ArrayList<>());
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            ++indegree[p[0]];
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int n = q.poll();
            ++count;
            for (int next : graph.get(n)) {
                --indegree[next];
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return count == numCourses;
    }

    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     HashMap<Integer, List<Integer>> graph = new HashMap<>();
    //     for (int i = 0; i < numCourses; ++i) graph.put(i, new ArrayList<>());
    //     for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);

    //     for (int i = 0; i < numCourses; ++i) traverse(i, graph, new boolean[numCourses], new boolean[numCourses]);
    //     return !hasCycle;
    // }

    // boolean hasCycle = false;
    // private void traverse(int n, HashMap<Integer, List<Integer>> graph, boolean[] visited, boolean[] path) {
    //     if (hasCycle) return;
    //     if (path[n]) {
    //         hasCycle = true;
    //         return;
    //     }
    //     if (visited[n]) return;

    //     visited[n] = true;
    //     path[n] = true;
    //     for (int next : graph.get(n)) {
    //         traverse(next, graph, visited, path);
    //     }
    //     path[n] = false;
    // }
}
