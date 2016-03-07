package solutions;

/**
 * https://leetcode.com/problems/gas-station/
 *
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation_134 {
    /*
     * Two questions:
     * 1. Can we complete the circuit?
     * Yes if total gas is greater than total cost; otherwise no.
     *
     * 2. Where is the starting point?
     * Fact: eg., A->B->C, if A can't reach C, neither can B.
     * Prove:
     * Given 1) gas[A] + gas[B] < cost[A] + cost[B] and
     *       2) gas[A] >= cost[A] (otherwise A can't even reach B, so A of course can't reach C)
     * We have gas[B] - cost[B] < cost[A] - gas[A] <= 0
     * Thus    gas[B] < cost[B]
     * ie., B can't reach C.
     * Therefore, any stations between A and C can't reach C, and none of them can be the starting point.
     *
     * Reference:
     * https://siddontang.gitbooks.io/leetcode-solution/content/greedy/gas_station.html
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) return -1;

        int start = 0;
        int currLeft = 0, totalLeft = 0;
        for (int i = 0; i < gas.length; ++i) {
            currLeft += gas[i] - cost[i];
            if (currLeft < 0) {
                start = i + 1;
                currLeft = 0;
            }
            totalLeft += gas[i] - cost[i];
        }
        return totalLeft < 0 ? -1 : start;
    }
}
