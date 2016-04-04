package solutions;

import java.util.HashMap;

import datastructure.UndirectedGraphNode;

/**
 * https://leetcode.com/problems/clone-graph/
 *
 * Clone an undirected graph. Each node in the graph contains a label and
 * a list of its neighbors.
 */
public class CloneGraph_130 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode n : node.neighbors) {
            newNode.neighbors.add(cloneGraph(n, map));
        }
        return newNode;
    }
}
