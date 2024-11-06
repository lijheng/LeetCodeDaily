package org.summer.leetcode.medium;

import java.util.Arrays;

/**
 * 3254. 长度为 K 的子数组的能量值 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
 *
 * 一个数组的 能量值 定义为：
 *
 * 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
 * 否则为 -1 。
 * 你需要求出 nums 中所有长度为 k 的
 * 子数组
 *  的能量值。
 *
 * 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,3,2,5], k = 3
 *
 * 输出：[3,4,-1,-1,-1]
 *
 * 解释：
 *
 * nums 中总共有 5 个长度为 3 的子数组：
 *
 * [1, 2, 3] 中最大元素为 3 。
 * [2, 3, 4] 中最大元素为 4 。
 * [3, 4, 3] 中元素 不是 连续的。
 * [4, 3, 2] 中元素 不是 上升的。
 * [3, 2, 5] 中元素 不是 连续的。
 */
public class Solution_3254 {
    public int[] resultsArray(int[] nums, int k) {
        int []result = new int[nums.length - k + 1];
        if (k == 1) {
            result = Arrays.copyOf(nums, result.length);
            return result;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length && i <= nums.length - k) {
            if (nums[j] != nums[j - 1] + 1) {
                result[i] = -1;
                i++;
                j = i + 1;
                continue;
            }
            if (j - i + 1 == k) {
                result[i] = nums[j];
                i++;
                j = i + 1;
                continue;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new Solution_3254().resultsArray(new int[]{1,2,3,4,3,2,5}, 3);
        System.out.println(Arrays.toString(result));
        result = new Solution_3254().resultsArray(new int[]{1,4}, 1);
        System.out.println(Arrays.toString(result));
        result = new Solution_3254().resultsArray(new int[]{1}, 1);
        System.out.println(Arrays.toString(result));
    }
}
