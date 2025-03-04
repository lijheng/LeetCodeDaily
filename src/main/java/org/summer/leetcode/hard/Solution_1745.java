package org.summer.leetcode.hard;

/**
 * 1745. 分割回文串 IV
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。
 *
 * 当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcbdd"
 * 输出：true
 * 解释："abcbdd" = "a" + "bcb" + "dd"，三个子字符串都是回文的。
 * 示例 2：
 *
 * 输入：s = "bcbddxy"
 * 输出：false
 * 解释：s 没办法被分割成 3 个回文子字符串。
 *
 * 提示：
 *
 * 3 <= s.length <= 2000
 * s 只包含小写英文字母。
 */
public class Solution_1745 {

    /**
     * @see org.summer.leetcode.medium.Solution_131#partition(String)
     * @param s
     * @return
     */
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean [][]dp = new boolean[n][n];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j-i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
            }
        }
        // 能否分割为三个回文子字符串，则主要确定中间一个回文字符串
        for (int i = 1; i < n-1; i++) {
            if (!dp[0][i-1]) {
                continue;
            }
            for (int j = i; j < n-1 ; j++) {
                if (dp[i][j] && dp[j+1][n-1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_1745 solution = new Solution_1745();
        System.out.println(solution.checkPartitioning("abcbdd"));
    }
}
