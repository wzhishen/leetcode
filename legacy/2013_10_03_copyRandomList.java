/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // A linked list is given such that each node contains an additional 
    // random pointer which could point to any node in the list or null.

    // Return a deep copy of the list.

    public RandomListNode copyRandomList(RandomListNode head) {
        return clone(head, new HashMap<RandomListNode, RandomListNode>());
    }
    
    private RandomListNode clone(RandomListNode n, HashMap<RandomListNode, RandomListNode> map) {
        if (n == null) return null;
        if (map.containsKey(n)) return map.get(n);
        RandomListNode clone = new RandomListNode(n.label);
        map.put(n, clone);
        clone.next = clone(n.next, map);
        clone.random = clone(n.random, map);
        return clone;
    }
}