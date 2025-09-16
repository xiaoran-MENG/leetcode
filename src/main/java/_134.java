public class _134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (sum(gas) < sum(cost)) return -1;
        int n = gas.length, sum = 0, result = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                result = i + 1;
            }
        }
        return result;
    }

    private int sum(int[] values) {
        int result = 0;
        for (int value : values) result += value;
        return result;
    }

    public int canCompleteCircuit_2(int[] gas, int[] cost) {
        int n = gas.length, prefixSum = 0, minPrefixSum = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += gas[i] - cost[i];
            if (prefixSum < minPrefixSum) {
                minPrefixSum = prefixSum;
                result = i + 1;
            }
        }
        return prefixSum < 0 ? -1 : result % n;
    }
}
