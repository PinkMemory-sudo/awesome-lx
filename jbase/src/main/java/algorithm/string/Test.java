package algorithm.string;

public class Test {

    public static void main(String[] args) {
//        nums = [3,2,2,3], val = 3
//        System.out.println(test(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    private static int test(int[] nums) {
        int length = nums.length;
        for (int i = 2; i < length; i++) {
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                length -= 1;
                i--;
            }
        }
        return length;
    }

    private static int testG(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    private static boolean skip(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxStep) {
                return false;
            }
            if (maxStep < i + nums[i]) {
                maxStep = i + nums[i];
            }
        }
        return true;
    }

    private static int skipNum(int[] nums) {
        int maxStep = 0;
        int stepNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == maxStep) {
                stepNum++;
            }
            if (i > maxStep) {
                return 0;
            }
            if (maxStep < i + nums[i]) {
                maxStep = i + nums[i];
            }
        }
        return stepNum;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int jumps = 0;
        int current_end = 0;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == current_end) {
                jumps++;
                current_end = farthest;
                if (current_end >= n - 1) {
                    break;
                }
            }
        }
        return jumps;
    }

    /**
     * 因为成环，所以能不能跑完一圈就看总油量和总消耗量
     * 为什么是唯一的
     * 为什么油量不足时，从下一个起点算起
     *
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0;
        int current_tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total_tank += gas[i] - cost[i];
            current_tank += gas[i] - cost[i];
            if (current_tank < 0) {
                start = i + 1;
                current_tank = 0;
            }
        }
        return total_tank >= 0 ? start : -1;
    }
}
