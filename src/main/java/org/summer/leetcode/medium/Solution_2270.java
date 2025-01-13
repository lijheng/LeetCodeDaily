package org.summer.leetcode.medium;

/**
 * 2270. 分割数组的方案数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
 * 如果以下描述为真，那么 nums 在下标 i 处有一个 合法的分割 ：
 * <p>
 * 前 i + 1 个元素的和 大于等于 剩下的 n - i - 1 个元素的和。
 * 下标 i 的右边 至少有一个 元素，也就是说下标 i 满足 0 <= i < n - 1 。
 * 请你返回 nums 中的 合法分割 方案数。
 * 示例 1：
 * <p>
 * 输入：nums = [10,4,-8,7]
 * 输出：2
 * 解释：
 * 总共有 3 种不同的方案可以将 nums 分割成两个非空的部分：
 * - 在下标 0 处分割 nums 。那么第一部分为 [10] ，和为 10 。第二部分为 [4,-8,7] ，和为 3 。因为 10 >= 3 ，所以 i = 0 是一个合法的分割。
 * - 在下标 1 处分割 nums 。那么第一部分为 [10,4] ，和为 14 。第二部分为 [-8,7] ，和为 -1 。因为 14 >= -1 ，所以 i = 1 是一个合法的分割。
 * - 在下标 2 处分割 nums 。那么第一部分为 [10,4,-8] ，和为 6 。第二部分为 [7] ，和为 7 。因为 6 < 7 ，所以 i = 2 不是一个合法的分割。
 * 所以 nums 中总共合法分割方案受为 2 。
 */
public class Solution_2270 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long [] sums = new long[n];
        sums[0] = nums[0];
        // 计算前[0, i]的和
        for (int i = 1; i < n - 1; i++) {
            sums[i] = sums[i -1] + nums[i];
        }
        // 计算[n-1, i)的和
        long[] reverseSums = new long[n];
        reverseSums[n-1] = nums[n-1];
        for (int i = n-2; i > 0 ; i--) {
            reverseSums[i] = reverseSums[i + 1] + nums[i];
        }
        // sum[i]的长度为n-1
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (sums[i] >= reverseSums[i+1]) {
                ans ++;
            }
        }
        return ans;
    }

    public int waysToSplitArray2(int[] nums) {
        long left = 0, right = 0;
        int n = nums.length;
        for (int num : nums) {
            right += num;
        }
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            left = left + nums[i];
            right =  right - nums[i];
            if (left >= right) {
                ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_2270 solution = new Solution_2270();
        System.out.println("waysToSplitArray:");
        System.out.println(solution.waysToSplitArray(new int[]{10,4,-8,7}));
        System.out.println(solution.waysToSplitArray(new int[]{2,3,1,0}));
        System.out.println("waysToSplitArray2:");
        System.out.println(solution.waysToSplitArray2(new int[]{10,4,-8,7}));
        System.out.println(solution.waysToSplitArray2(new int[]{2,3,1,0}));
    }
}
