package dp;

/**
 * 凑硬币
 * dp[i]=dp[i-cons]+1;
 * dp[0]=0;
 * <p>
 * 初始值
 * 已知前n项求当前项
 * 解题思路
 * 正着想(自底向上)，如果第一个，那么后面，算出第一个、第2、3、4......
 * 倒着项(自顶向下)：如果最后一个，那么前面，假设前n个已知，求第n个(递归)
 */
public class CoinsTest {
    public static void main(String[] args) {
        System.out.println(getNumber(new int[]{186,419,83,408}, 6249));
    }

    private static int getNumber(int[] coins, int amount) {
        int[] dpTable = new int[amount + 1];
        dpTable[0] = 0;
        for (int coin : coins) {
            if (coin<=amount) {
                dpTable[coin] = 1;
            }
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int con : coins) {
                // dp[i-con]+1
                if (i - con > 0 && dpTable[i - con] != -1) {
                    if (dpTable[i] == 0) {
                        dpTable[i] = dpTable[i - con] + 1;
                    } else if (dpTable[i] > dpTable[i - con] + 1) {
                        dpTable[i] = dpTable[i - con] + 1;
                    }
                }
            }
            if (dpTable[i] == 0) {
                dpTable[i] = -1;
            }
        }
        return dpTable[amount];
    }
}
