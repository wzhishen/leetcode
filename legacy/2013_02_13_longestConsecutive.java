public class Solution {
    // Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    // For example,
    // Given [100, 4, 200, 1, 3, 2],
    // The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

    // Your algorithm should run in O(n) complexity.
    
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i : num) q.offer(i);
        int prev = Integer.MIN_VALUE;
        int cnt = 1;
        int maxcnt = 1;
        while(!q.isEmpty()) {
            int i = q.poll();
            if (i == prev + 1) {
                ++cnt;
            }
            else if (i == prev) {
                continue;
            }
            else {
                if (cnt > maxcnt) maxcnt = cnt;
                cnt = 1;
            }
            prev = i;
        }
        if (cnt > maxcnt) maxcnt = cnt;
        return maxcnt;
     }
}