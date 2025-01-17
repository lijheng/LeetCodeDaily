package org.summer.leetcode.easy;

/**
 * 3095. 或值至少 K 的最短子数组 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * <p>
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * <p>
 * 请你返回 nums 中 最短特别非空
 * 子数组
 * 的长度，如果特别子数组不存在，那么返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], k = 2
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。
 * <p>
 * 注意，[2] 也是一个特别子数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,8], k = 10
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。
 */
public class Solution_3095 {

    /**
     * 暴力求解
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp = nums[j] | temp;
                if (temp >= k) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 滑动窗口
     */
    public int minimumSubarrayLength2(int[] nums, int k) {
        //todo
        return 0;
    }
    public static void main(String[] args) {
        Solution_3095 solution = new Solution_3095();
        System.out.println("minimumSubarrayLength:");
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(solution.minimumSubarrayLength(new int[]{2, 1, 8}, 10));
    }
}