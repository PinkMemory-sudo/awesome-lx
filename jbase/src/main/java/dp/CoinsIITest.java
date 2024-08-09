package dp;

import java.util.Arrays;

/**
 * 有几种凑法
 * <p>
 * 完全背包
 * 记忆化搜索
 */
public class CoinsIITest {

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{2, 1, 5}));
    }

    // 排列数
//    public static int change(int amount, int[] coins) {
//        int[] memo = new int[amount + 1];
//        memo[0]=1;
//        for (int i = 0; i < amount + 1; i++) {
//            for (int coin : coins) {
//                if (i - coin >= 0) {
//                    memo[i] += memo[i - coin];
//                }
//            }
//        }
//        return memo[amount];
//    }


    // 组合数
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            System.out.println("\ncoin: " + coin);
            // 用滚动数组压缩,只能以coin结尾，且不能包含coin之后的硬币
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
                System.out.println("dp[" + i + "]= " + dp[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

}
