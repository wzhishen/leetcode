package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 *
 * Given a list of airline tickets represented by pairs of departure
 * and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the
 * itinerary must begin with JFK.
 *
 * Note:
 * 1. If there are multiple valid itineraries, you should return the
 * itinerary that has the smallest lexical order when read as a single
 * string. For example, the itinerary ["JFK", "LGA"] has a smaller
 * lexical order than ["JFK", "LGB"].
 * 2. All airports are represented by three capital letters (IATA code).
 * 3. You may assume all tickets form at least one valid itinerary.
 *
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 *
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 */
public class ReconstructItinerary_332 {
    // DFS
    // Ref: http://blog.5ibc.net/p/41458.html
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if (tickets == null) return res;
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) graph.put(ticket[0], new ArrayList<String>());
            graph.get(ticket[0]).add(ticket[1]);
        }
        for (ArrayList<String> tos : graph.values()) Collections.sort(tos);
        res.add("JFK");
        dfs(graph, res, "JFK", tickets.length + 1);
        return res;
    }

    private boolean dfs(HashMap<String, ArrayList<String>> graph, List<String> res, String from, int len) {
        if (res.size() == len) return true;
        if (graph.containsKey(from)) {
            ArrayList<String> tos = graph.get(from);
            for (int i = 0; i < tos.size(); ++i) {
                String to = tos.get(i);
                res.add(to);
                tos.remove(i);
                if (dfs(graph, res, to, len)) return true;
                res.remove(res.size() - 1);
                tos.add(i, to);
            }
        }
        return false;
    }

    // Optimal: Eulerian path
    // Ref: http://bookshadow.com/weblog/2016/02/05/leetcode-reconstruct-itinerary/
}
