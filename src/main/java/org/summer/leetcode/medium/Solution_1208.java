package org.summer.leetcode.medium;

/**
 * 1208. 尽可能使字符串相等
 * 给你两个长度相同的字符串，s 和 t。
 * <p>
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * <p>
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * <p>
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * <p>
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", t = "cdef", maxCost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 * <p>
 * 输入：s = "abcd", t = "acde", maxCost = 0
 * 输出：1
 * 解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 */
public class Solution_1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int left = 0, right = 0;
        int n = s.length(); // s和 t长度相等
        int cost = 0;
        while (right < n) {
            cost = cost + Math.abs(s.charAt(right) - t.charAt(right));
            while (cost > maxCost) {
                cost = cost - Math.abs(s.charAt(left) - t.charAt(left));
                left++;
                if (left == right) { //如果加到right时仍然不满足，则应该跳出循环，进行下一次窗口构建，此时left = right, right = right+1
                    break;
                }
            }
            ans = Math.max(ans, right-left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_1208 solution = new Solution_1208();
        System.out.println("equalSubstring: ");
        System.out.println(solution.equalSubstring("abcd", "bcdf", 3));
        System.out.println(solution.equalSubstring("abcd", "cdef", 3));
        System.out.println(solution.equalSubstring("abcd", "acde", 0));
        System.out.println(solution.equalSubstring("krrgw", "zjxss", 19));
    }
}
