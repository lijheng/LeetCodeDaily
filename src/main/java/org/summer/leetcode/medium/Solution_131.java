package org.summer.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class Solution_131 {

    private final List<List<String>> mAns = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        // dp[i][j]表示字符串[i,j]是否是回文串
        // dp[i][j] 是否是回文串可以通过 dp[i+1][j-1] && s[i]==s[j]
        boolean [][]dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], false);
        }
        for (int i = n-1; i>=0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
            }
        }
        dfs(s, 0, n, dp);
        return mAns;
    }

    /**
     * 原始字符串长度
     */
    private final List<String> temp = new ArrayList<>();
    private void dfs(String s, int start, int n, boolean[][] dp) {
        if (start == n) {
            mAns.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < n; i++) {
            if (dp[start][i]) {
                temp.add(s.substring(start, i+1));
                dfs(s, i+1, n, dp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution_131 solution = new Solution_131();
        List<List<String>> ret = solution.partition("abacb");
        for (List<String> strings : ret) {
            System.out.println(Arrays.toString(strings.toArray()));
        }
    }
}
