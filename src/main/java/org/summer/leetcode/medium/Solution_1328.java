package org.summer.leetcode.medium;

/**
 * 1328. 破坏回文串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由小写英文字母组成的回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的 字典序最小 ，且 不是 回文串。
 * <p>
 * 请你返回结果字符串。如果无法做到，则返回一个 空串 。
 * <p>
 * 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符严格小于 b 中的对应字符。例如，"abcc” 字典序比 "abcd" 小，因为不同的第一个位置是在第四个字符，显然 'c' 比 'd' 小。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：palindrome = "abccba"
 * 输出："aaccba"
 * 解释：存在多种方法可以使 "abccba" 不是回文，例如 "zbccba", "aaccba", 和 "abacba" 。
 * 在所有方法中，"aaccba" 的字典序最小。
 * 示例 2：
 * <p>
 * 输入：palindrome = "a"
 * 输出：""
 * 解释：不存在替换一个字符使 "a" 变成非回文的方法，所以返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= palindrome.length <= 1000
 * palindrome 只包含小写英文字母。
 */
public class Solution_1328 {
    public String breakPalindrome(String palindrome) {
        // 由于palindrome是回文串，则palindrome的前半和后半字符相等，故只需要将前半的某个字符进行替换则变为非回文串
        // 为了让字典序最小，则将最前面的字符替换为a
        int n = palindrome.length();
        if (n <= 1) {
            return "";
        }
        int mid = n / 2;
        char[] data = palindrome.toCharArray();
        for (int i = 0; i < mid; i++) {
            if (palindrome.charAt(i) != 'a') {
                data[i] = 'a';
                return new String(data);
            }
        }
        // 所有字母都为a, 为了使字节序最小，则将最后一个替换为b
        data[n - 1] = 'b';
        return new String(data);
    }

    public static void main(String[] args) {
        System.out.println("breakPalindrome:");
        Solution_1328 solution = new Solution_1328();
        System.out.println(solution.breakPalindrome("abccba"));
    }
}
