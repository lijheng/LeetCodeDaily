package org.summer.leetcode.easy;

/**
 * 给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 行有 3 个球，依此类推。
 * 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
 * 返回可以实现的三角形的 最大 高度。
 * <p>
 * <p>
 * 示例 1：
 * 输入： red = 2, blue = 4
 * 输出： 3
 * 解释：
 * blue
 * red  red
 * blue blue  blue
 * 上图显示了唯一可能的排列方式。
 */
public class Solution_3200 {
    public int maxHeightOfTriangle(int red, int blue) {
        // 总共两种可能，第一行是蓝色 或者 第一行是红色
        return Math.max(maxHeightOfTriangle(red, blue, true), maxHeightOfTriangle(red, blue, false));
    }

    private int maxHeightOfTriangle(int red, int blue, boolean isFirstRed) {
        int height = 0;
        int lineWidth = 1;
        boolean isRed = isFirstRed;
        while (true) {
            if (isRed) {
                red = red - lineWidth;
            } else {
                blue = blue - lineWidth;
            }
            isRed = !isRed;
            lineWidth++;
            if (red >= 0 && blue >= 0) {
                height++;
            } else if ((red < 0 && isRed) || (blue < 0 && !isRed)) {
                break;
            }
        }
        return height;
    }

    public int maxHeightOfTriangle2(int red, int blue) {
        // 等差数列公式 Sn = n(a1 + a2) / 2
        // 奇数行所需球数量分别为 1 3 5 7 .... (2n-1)  根据等差数列公式 Sn = n(1 + (2n-1))/2 = n^2
        // 偶数行所需球数量分别为 2 4 6 8 .... 2n  根据等差数列公式 Sn = n(2 + 2n) /2 = n + n^2
        // 假设提供给偶数行的是blue，则 n + n^2 <= blue && n^2 <= red
        return Math.max(maxHeightOfTriangle2(red, blue, true), maxHeightOfTriangle2(red, blue, false));
    }

    public int maxHeightOfTriangle2(int red, int blue, boolean isRed) {
        int x, y;
        if (isRed) {
            x = red;
            y = blue;
        } else {
            x = blue;
            y = red;
        }
        int odd = 2 * (int) (Math.sqrt(x)) - 1;
        int even = 2 * (int) ((-1 + Math.sqrt(1 + 4 * y)) / 2);
        return Math.min(odd, even) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_3200().maxHeightOfTriangle(2, 4));
        System.out.println(new Solution_3200().maxHeightOfTriangle2(2, 4));
    }
}
