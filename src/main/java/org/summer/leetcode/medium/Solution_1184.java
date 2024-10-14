package org.summer.leetcode.medium;

import java.util.Arrays;

/**
 * 1884. 鸡蛋掉落-两枚鸡蛋
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 * <p>
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
 * 如果第一枚鸡蛋碎了，可知 f = 0；
 * 如果第二枚鸡蛋碎了，但第一枚没碎，可知 f = 1；
 * 否则，当两个鸡蛋都没碎时，可知 f = 2。
 */
public class Solution_1184 {
    /**
     *
     * 对于n层楼，第一个鸡蛋扔到任意k层
     *   鸡蛋碎：此时只剩一个鸡蛋的情况则需要从第一层开始逐层扔下鸡蛋来保证找到鸡蛋碎的楼层，故 f(n) = k
     *   鸡蛋不碎: 此时则需要找到在[k,n]之间使用两枚鸡蛋找到鸡蛋掉落会碎掉的楼层，即 f(n) = 1 + f(n-k)
     */
    public int twoEggDrop(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], Math.max(j, dp[i - j] + 1));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1184().twoEggDrop(2));
        System.out.println(new Solution_1184().twoEggDrop(100));
    }
}
