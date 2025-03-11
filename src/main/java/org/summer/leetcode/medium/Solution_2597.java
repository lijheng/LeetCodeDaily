package org.summer.leetcode.medium;

import java.util.Arrays;

/**
 * 2597. 美丽子集的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由正整数组成的数组 nums 和一个 正 整数 k 。
 *
 * 如果 nums 的子集中，任意两个整数的绝对差均不等于 k ，则认为该子数组是一个 美丽 子集。
 *
 * 返回数组 nums 中 非空 且 美丽 的子集数目。
 *
 * nums 的子集定义为：可以经由 nums 删除某些元素（也可能不删除）得到的一个数组。只有在删除元素时选择的索引不同的情况下，两个子集才会被视作是不同的子集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,4,6], k = 2
 * 输出：4
 * 解释：数组 nums 中的美丽子集有：[2], [4], [6], [2, 6] 。
 * 可以证明数组 [2,4,6] 中只存在 4 个美丽子集。
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：1
 * 解释：数组 nums 中的美丽数组有：[1] 。
 * 可以证明数组 [1] 中只存在 1 个美丽子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 18
 * 1 <= nums[i], k <= 1000
 */
public class Solution_2597 {

    public int beautifulSubsets(int[] nums, int k) {
       return 0;
    }

    public static void main(String[] args) {
        Solution_2597 solution = new Solution_2597();
        solution.beautifulSubsets(new int[]{2,4,6}, 4);
    }
}
