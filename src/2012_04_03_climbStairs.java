public class Solution {
    // You are climbing a stair case. It takes n steps to reach to the top.

    // Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<Integer, Integer>());
    }
    
    private int climbStairs(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n < 0) return 0;
        if (n == 0) return 1;
        int res = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
        cache.put(n, res);
        return res;
    }
}