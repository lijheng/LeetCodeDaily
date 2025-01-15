package org.summer.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3066. 超过阈值的最少操作数 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 *
 * 一次操作中，你将执行：
 *
 * 选择 nums 中最小的两个整数 x 和 y 。
 * 将 x 和 y 从 nums 中删除。
 * 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
 * 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
 *
 * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,11,10,1,3], k = 10
 * 输出：2
 * 解释：第一次操作中，我们删除元素 1 和 2 ，然后添加 1 * 2 + 2 到 nums 中，nums 变为 [4, 11, 10, 3] 。
 * 第二次操作中，我们删除元素 3 和 4 ，然后添加 3 * 2 + 4 到 nums 中，nums 变为 [10, 11, 10] 。
 * 此时，数组中的所有元素都大于等于 10 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 10 需要的最少操作次数为 2 。
 * 示例 2：
 *
 * 输入：nums = [1,1,2,4,9], k = 20
 * 输出：4
 * 解释：第一次操作后，nums 变为 [2, 4, 9, 3] 。
 * 第二次操作后，nums 变为 [7, 4, 9] 。
 * 第三次操作后，nums 变为 [15, 9] 。
 * 第四次操作后，nums 变为 [33] 。
 * 此时，数组中的所有元素都大于等于 20 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 20 需要的最少操作次数为 4 。
 */
public class Solution_3066 {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        // 优先队列
        PriorityQueue<Long> pq = new PriorityQueue<>(n);
        for (long num : nums) {
            pq.offer(num);
        }
        int opCount = 0;
        Long temp = null;
        while (((temp = pq.peek()) != null) && temp < k) {
            long x = pq.poll();
            long y;
            if (pq.peek() == null) {
                break;
            } else {
                y = pq.poll();
            }
            pq.offer(x * 2 + y);
            opCount++;
        }
        return opCount;
    }

    public static void main(String[] args) {
        Solution_3066 solution = new Solution_3066();
        System.out.println("minOperations: ");
        System.out.println(solution.minOperations(new int[]{2,11,10,1,3}, 10));
        System.out.println(solution.minOperations(new int[]{1,1,2,4,9}, 20));
    }
}
