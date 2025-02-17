package org.summer.leetcode.easy;

/**
 * 1287. 有序数组中出现次数超过25%的元素
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 *
 *
 * 示例：
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
public class Solution_1287 {
    public int findSpecialInteger(int[] arr) {
        // 题目中限定了数组大小最小为1
        int count = 1;
        int n = arr.length;
        int ans = arr[0];
        int targetCount = n / 4;
        for (int i = 1; i < n; i++) {
            if (ans == arr[i]) {
                count++;
                if (count > targetCount) {
                    return ans;
                }
            } else {
                count = 1;
                ans = arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_1287 solution = new Solution_1287();
        System.out.println("findSpecialInteger:");
        System.out.println(solution.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        System.out.println(solution.findSpecialInteger(new int[]{1, 1}));
    }
}
