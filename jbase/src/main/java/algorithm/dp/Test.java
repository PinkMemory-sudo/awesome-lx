package algorithm.dp;

public class Test {

    /**
     * 爬楼梯
     */
    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    /**
     * 爬楼梯优化：每次计算只需要知道前两个的值，只使用两个变量保存就行
     */
    public static int climbStairs2(int n) {
        if (n < 3) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int closeValue = Math.max(nums[0], nums[1]);
        int interval = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int temp = closeValue;
            closeValue = Math.max(closeValue, nums[i] + interval);
            interval = temp;
        }
        return closeValue;
    }

    /**
     * 双指针对比,判断子序列
     * 每个指针移动的边界问题
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length() && j < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i == s.length()) {
                return true;
            }
        }
        return i == s.length();
    }

    public boolean isSubsequence1(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i == s.length()) {
                return true;
            }
        }
        return i == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public boolean isSubsequence3(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    /**
     * 凑硬币
     * 拆解子问题，推到状态转移方程
     * 广度优先搜索
     * amount + 1
     */
    public static int coinChange(int[] coins, int amount) {
        // 初始化dp数组
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 3}, 3));
    }

}
