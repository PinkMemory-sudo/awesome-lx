public class KnapsackBacktracking {
    private int maxValue = 0;

    public int knapsack(int W, int[] weights, int[] values, int n) {
        backtrack(0, 0, 0, W, weights, values, n);
        return maxValue;
    }

    private void backtrack(int i, int currentWeight, int currentValue, int W, int[] weights, int[] values, int n) {
        // 如果当前重量已经超过了背包容量，停止这个路径的搜索
        if (currentWeight > W) {
            return;
        }

        // 如果已经遍历完所有物品，更新最大价值
        if (i == n) {
            maxValue = Math.max(maxValue, currentValue);
            return;
        }

        // 选择不将第 i 个物品放入背包
        backtrack(i + 1, currentWeight, currentValue, W, weights, values, n);

        // 选择将第 i 个物品放入背包
        backtrack(i + 1, currentWeight + weights[i], currentValue + values[i], W, weights, values, n);
    }

    public static void main(String[] args) {
        KnapsackBacktracking ks = new KnapsackBacktracking();
        int W = 1000000;
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 22, 33, 44, 99, 88, 77, 11, 22, 33, 111, 222, 333, 444, 555, 666,
                777, 888, 999, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        int[] values = {1, 2, 3, 4, 5, 6, 8, 7, 9, 77, 88, 99, 11, 22, 33, 44, 55, 66, 111, 222, 333, 444, 555, 666,
                777, 888, 999, 1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999};
        int n = weights.length;
        long l = System.currentTimeMillis();
        System.out.println(ks.dpKnapsack(W, weights, values, n));
        System.out.println(System.currentTimeMillis() - l);
        l = System.currentTimeMillis();
        int maxValue = ks.knapsack(W, weights, values, n);
        System.out.println(maxValue);
        System.out.println(System.currentTimeMillis() - l);
    }


    public int dpKnapsack(int W, int[] weights, int[] values, int n) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = W; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        return dp[W];
    }

}
