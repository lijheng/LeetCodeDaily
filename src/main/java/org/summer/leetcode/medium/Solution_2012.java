package org.summer.leetcode.medium;

/**
 * 2012. 数组美丽值求和
 * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 * <p>
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
 * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
 * 0，如果上述条件全部不满足
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 2
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6,4]
 * 输出：1
 * 解释：对于每个符合范围 1 <= i <= 2 的下标 i :
 * - nums[1] 的美丽值等于 1
 * - nums[2] 的美丽值等于 0
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Solution_2012 {


    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        // 根据题目描述分析得知 nums[0]的美丽值一定为0， num[n-1]的美丽值也为0
        // 美丽值为2的条件为 i左边的都比它小 右边的都比它大
        // 美丽值为1的条件为  nums[i - 1] < nums[i] < nums[i + 1]

        int[] max = new int[n];// 存储[0,i)时的最大值
        max[0] = nums[0];
        max[1] = nums[0];
        for (int i = 2; i < n; i++) {
            max[i] = Math.max(nums[i - 1], max[i - 1]);
        }
        int ans = 0;
        int preMin = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (preMin > nums[i] && nums[i] > max[i]) {
                ans += 2;
            } else if (nums[i + 1] > nums[i] && nums[i] > nums[i - 1]) {
                ans += 1;
            }
            preMin = Math.min(preMin, nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_2012 solution = new Solution_2012();
//        System.out.println(solution.sumOfBeauties(new int[]{1, 2, 3}));
//        System.out.println(solution.sumOfBeauties(new int[]{2,4,6,4}));
//        System.out.println(solution.sumOfBeauties(new int[]{3, 2, 1}));
        System.out.println(solution.sumOfBeauties(new int[]{3,13,10,3,3,12,20,16}));
    }
}
