package org.summer.leetcode.medium;

/**
 * 3191. 使二进制数组全部等于 1 的最少操作次数 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二进制数组 nums 。
 * <p>
 * 你可以对数组执行以下操作 任意 次（也可以 0 次）：
 * <p>
 * 选择数组中 任意连续 3 个元素，并将它们 全部反转 。
 * 反转 一个元素指的是将它的值从 0 变 1 ，或者从 1 变 0 。
 * <p>
 * 请你返回将 nums 中所有元素变为 1 的 最少 操作次数。如果无法全部变成 1 ，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,1,1,0,0]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * 我们可以执行以下操作：
 * <p>
 * 选择下标为 0 ，1 和 2 的元素并反转，得到 nums = [1,0,0,1,0,0] 。
 * 选择下标为 1 ，2 和 3 的元素并反转，得到 nums = [1,1,1,0,0,0] 。
 * 选择下标为 3 ，4 和 5 的元素并反转，得到 nums = [1,1,1,1,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1]
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * 无法将所有元素都变为 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 1
 */
public class Solution_3191 {

    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                continue;
            }
            // 少于三个元素，但是当前元素为0，即无法交换了
            if (i + 1 == n || i + 2 == n) {
                count = -1;
                break;
            }
            nums[i] = 1;
            nums[i + 1] = nums[i + 1] == 1 ? 0 : 1;
            nums[i + 2] = nums[i + 2] == 1 ? 0 : 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_3191().minOperations(new int[]{0,1,1,1,0,0}));
        System.out.println(new Solution_3191().minOperations(new int[]{0,1,1,1}));
    }
}
