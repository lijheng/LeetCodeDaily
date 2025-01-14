package org.summer.leetcode.easy;

/**
 * 3065. 超过阈值的最少操作数 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 *
 * 一次操作中，你可以删除 nums 中的最小元素。
 *
 * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,11,10,1,3], k = 10
 * 输出：3
 * 解释：第一次操作后，nums 变为 [2, 11, 10, 3] 。
 * 第二次操作后，nums 变为 [11, 10, 3] 。
 * 第三次操作后，nums 变为 [11, 10] 。
 * 此时，数组中的所有元素都大于等于 10 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 10 需要的最少操作次数为 3 。
 */
public class Solution_3065 {

    // 2 11 10 1 3
    // 3 11 10 1 2
    // 1 11 10 3 2
    // 10 11 1 3 2

    public int minOperations(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - count; i++) {
            if (nums[i] < k) {
                int m = n - count - 1;
                int temp = nums[i];
                nums[i] = nums[m];
                nums[m] = temp;
                i--; //为了再次访问换回该位置的元素是否满足条件
                count++;
            }
        }
        return count;
    }

    // 题目只需要统计操作次数，并不需要真正交换
    public int minOperations2(int[] nums, int k) {
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution_3065 solution = new Solution_3065();
        System.out.println("minOperations: ");
        System.out.println(solution.minOperations(new int[]{2,11,10,1,3}, 10));
        System.out.println(solution.minOperations(new int[]{1,1,2,4,9}, 1));
        System.out.println(solution.minOperations(new int[]{1,1,2,4,9}, 9));
        System.out.println("minOperations2: ");
        System.out.println(solution.minOperations2(new int[]{2,11,10,1,3}, 10));
        System.out.println(solution.minOperations2(new int[]{1,1,2,4,9}, 1));
        System.out.println(solution.minOperations2(new int[]{1,1,2,4,9}, 9));
    }
}
