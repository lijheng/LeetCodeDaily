package org.summer.leetcode.medium;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Solution_3 {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0, right = 0;
        int n = s.length();
        HashSet<Character> characters = new HashSet<>();
        while (right < n) {
            char current = s.charAt(right);
            if (characters.contains(current)) {
                ans = Math.max(ans, right - left);
            }
            while (characters.contains(current) && left < right) {
                characters.remove(s.charAt(left));
                left++;
            }
            characters.add(current);
            right++;
        }
        return Math.max(ans, right - left);
    }

    public static void main(String[] args) {
//        System.out.println("lengthOfLongestSubstring: " + new Solution_3().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println("lengthOfLongestSubstring: " + new Solution_3().lengthOfLongestSubstring("bbbbb"));
//        System.out.println("lengthOfLongestSubstring: " + new Solution_3().lengthOfLongestSubstring("pwwkew"));
//        System.out.println("lengthOfLongestSubstring: " + new Solution_3().lengthOfLongestSubstring(" "));
        System.out.println("lengthOfLongestSubstring: " + new Solution_3().lengthOfLongestSubstring("dvdf"));
    }
}
