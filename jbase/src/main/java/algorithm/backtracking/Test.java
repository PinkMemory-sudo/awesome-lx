package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

    }

    /**
     * 全排列,便利决策树
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // 标记元素是否被使用
        backtrack(nums, new ArrayList<>(), used, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path)); // 深拷贝当前路径到结果集
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 选择当前元素
                used[i] = true;
                path.add(nums[i]);

                backtrack(nums, path, used, res);
                // 撤销选择（回溯）
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    /**
     * 电话号码的字母组合
     */

    /**
     * 用重复元素的重排列
     */

    /**
     * 组合总和(元素可重用)
     */

    /**
     * 组合总和(元素不可重用)
     */

    /**
     * N皇后
     */

    /**
     * 子集问题
     */

    /**
     * 子集问题(含重复元素)
     */

    /**
     * 括号生成
     */

    /**
     * 复制原IP
     */

    /**
     *
     */


}
