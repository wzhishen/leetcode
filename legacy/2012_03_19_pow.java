public class Solution {
    // Implement pow(x, n).
    
    public double pow(double x, int n) {
        if (x == 1 || n == 0) return 1;
        if (x < 0) return n % 2 == 0 ? pow(-x, n) : -1 * pow(-x, n);
        if (n < 0) return pow(1/x, -n);
        return pow(x, n, new HashMap<Integer, Double>());
    }
    
    private double pow(double x, int n, HashMap<Integer, Double> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n == 1) return x;
        double res;
        if (n % 2 == 0) 
            res = pow(x, n/2, cache) * pow(x, n/2, cache);
        else
            res = x * pow(x, n/2, cache) * pow(x, n/2, cache);
        cache.put(n, res);
        return res;
    }
}