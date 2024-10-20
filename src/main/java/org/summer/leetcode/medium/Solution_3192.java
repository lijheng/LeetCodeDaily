package org.summer.leetcode.medium;

/**
 * 3192. 使二进制数组全部等于 1 的最少操作次数 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二进制数组 nums 。
 * <p>
 * 你可以对数组执行以下操作 任意 次（也可以 0 次）：
 * <p>
 * 选择数组中 任意 一个下标 i ，并将从下标 i 开始一直到数组末尾 所有 元素 反转 。
 * 反转 一个元素指的是将它的值从 0 变 1 ，或者从 1 变 0 。
 * <p>
 * 请你返回将 nums 中所有元素变为 1 的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,1,0,1]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 我们可以执行以下操作：
 * <p>
 * 选择下标 i = 1 执行操作，得到 nums = [0,0,0,1,0] 。
 * 选择下标 i = 0 执行操作，得到 nums = [1,1,1,0,1] 。
 * 选择下标 i = 4 执行操作，得到 nums = [1,1,1,0,0] 。
 * 选择下标 i = 3 执行操作，得到 nums = [1,1,1,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,0,0]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * 我们可以执行以下操作：
 * <p>
 * 选择下标 i = 1 执行操作，得到 nums = [1,1,1,1] 。
 */
public class Solution_3192 {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int num : nums) {
            boolean reversal = count % 2 == 1; // 每一次反转操作都会使的i以后的数字取反，故偶数操作后是其本身，奇数时为反转后的数字
            int realNum = reversal ? (num == 1 ? 0 : 1) : num;
            if (realNum == 1) {
                continue;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_3192().minOperations(new int[]{0, 1, 1, 0, 1}));
        System.out.println(new Solution_3192().minOperations(new int[]{1,0,0,0}));
    }
}
