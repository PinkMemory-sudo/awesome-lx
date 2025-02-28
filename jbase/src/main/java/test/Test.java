package test;


import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // nums1 的有效部分最后一个元素
        int j = n - 1;  // nums2 的最后一个元素
        int k = m + n - 1;  // nums1 的最后一个位置

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        String[] split = s.split("");
        int sum = map.get(split[split.length - 1]);
        for (int i = 0; i < split.length - 1; i++) {
            if (map.get(split[i]) < map.get(split[i + 1])) {
                sum -= map.get(split[i]);
            } else {
                sum += map.get(split[i]);
            }
        }
        return sum;
    }


    public static void rotate(int[] nums, int k) {
        int[] ints = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            ints[i - nums.length + k] = nums[i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = ints[i];
        }
    }

    public static void main(String[] args) {
//        int[] ints = {1, 2, 1};
        int[] ints = {1};
    }


}
