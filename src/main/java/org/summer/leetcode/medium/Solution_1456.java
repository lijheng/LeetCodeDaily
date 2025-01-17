package org.summer.leetcode.medium;

/**
 * 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 *
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 *
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 *
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 *
 * 输入：s = "tryhard", k = 4
 * 输出：1
 *
 */
public class Solution_1456 {

    public int maxVowels(String s, int k) {
        int ans = 0;
        int n = s.length();
        int right = 0;
        int tempCount = 0;
        while (right < n) {
            tempCount += isYuan(s.charAt(right));
            right++;
            if (right >= k) {
                ans = Math.max(tempCount, ans);
                tempCount =  tempCount - isYuan(s.charAt(right - k));
            }
        }
        return ans;
    }

    private int isYuan(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> 1;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        Solution_1456 solution = new Solution_1456();
        System.out.println("maxVowels: ");
        System.out.println(solution.maxVowels("abciiidef", 3)); // 3
        System.out.println(solution.maxVowels("aeiou", 2));  //2
        System.out.println(solution.maxVowels("leetcode", 3));//2
        System.out.println(solution.maxVowels("rhythms", 4));//0
        System.out.println(solution.maxVowels("tryhard", 4));//1
    }
}
