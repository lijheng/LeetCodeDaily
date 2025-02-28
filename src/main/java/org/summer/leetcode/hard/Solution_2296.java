package org.summer.leetcode.hard;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 2296. 设计一个文本编辑器
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个带光标的文本编辑器，它可以实现以下功能：
 * <p>
 * 添加：在光标所在处添加文本。
 * 删除：在光标所在处删除文本（模拟键盘的删除键）。
 * 移动：将光标往左或者往右移动。
 * 当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，也就是说任意时候 0 <= cursor.position <= currentText.length 都成立。
 * <p>
 * 请你实现 TextEditor 类：
 * <p>
 * TextEditor() 用空文本初始化对象。
 * void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
 * int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。
 * string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TextEditor", "addText", "deleteText", "addText", "cursorRight", "cursorLeft", "deleteText", "cursorLeft", "cursorRight"]
 * [[], ["leetcode"], [4], ["practice"], [3], [8], [10], [2], [6]]
 * 输出：
 * [null, null, 4, null, "etpractice", "leet", 4, "", "practi"]
 * <p>
 * 解释：
 * TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
 * textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
 * textEditor.deleteText(4); // 返回 4
 * // 当前文本为 "leet|" 。
 * // 删除了 4 个字符。
 * textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
 * textEditor.cursorRight(3); // 返回 "etpractice"
 * // 当前文本为 "leetpractice|".
 * // 光标无法移动到文本以外，所以无法移动。
 * // "etpractice" 是光标左边的 10 个字符。
 * textEditor.cursorLeft(8); // 返回 "leet"
 * // 当前文本为 "leet|practice" 。
 * // "leet" 是光标左边的 min(10, 4) = 4 个字符。
 * textEditor.deleteText(10); // 返回 4
 * // 当前文本为 "|practice" 。
 * // 只有 4 个字符被删除了。
 * textEditor.cursorLeft(2); // 返回 ""
 * // 当前文本为 "|practice" 。
 * // 光标无法移动到文本以外，所以无法移动。
 * // "" 是光标左边的 min(10, 0) = 0 个字符。
 * textEditor.cursorRight(6); // 返回 "practi"
 * // 当前文本为 "practi|ce" 。
 * // "practi" 是光标左边的 min(10, 6) = 6 个字符。
 */
public class Solution_2296 {
    //投机取巧版
    public static class TextEditor {
        private StringBuilder content = new StringBuilder();
        private int cursor = 0;

        public TextEditor() {

        }

        public void addText(String text) {
            content.insert(cursor, text);
            cursor += text.length();
        }

        public int deleteText(int k) {
            int end = cursor;
            cursor = Math.max(0, cursor - k);
            content.delete(cursor, end);
            return end - cursor;
        }

        public String cursorLeft(int k) {
            cursor = Math.max(0, cursor - k);
            return content.substring(Math.max(cursor - 10, 0), cursor);
        }

        public String cursorRight(int k) {
            cursor = Math.min(content.length(), cursor + k);
            return content.substring(Math.max(cursor - 10, 0), cursor);
        }
    }

    /**
     * 使用自定义容器来存储文本
     * */
    public static class TextEditor2 {

        private final LinkedList<Character> left = new LinkedList<>();
        private final LinkedList<Character> right = new LinkedList<>();

        public TextEditor2() {

        }

        public void addText(String text) {
            for (char c : text.toCharArray()) {
                left.addLast(c);
            }
        }

        public int deleteText(int k) {
            int i = 0;
            for (; i < k; i++) {
                if (left.pollLast() == null) {
                    break;
                }
            }
            return i;
        }

        public String cursorLeft(int k) {
            for (int i = 0; i < k; i++) {
                Character c = left.pollLast();
                if (c == null) {
                    break;
                }
                right.push(c);
            }

            return getString(left);
        }

        /**
         * 返回最后10个字母组成的字符串
         */
        private String getString(LinkedList<Character> list) {
            StringBuilder builder = new StringBuilder();
            ListIterator<Character> iterator = list.listIterator(list.size());
            for (int i = 0; i < 10; i++) {
                if (!iterator.hasPrevious()) {
                    break;
                }
                Character c = iterator.previous();
                builder.insert(0, c);
            }
            return builder.toString();
        }

        public String cursorRight(int k) {
            for (int i = 0; i < k; i++) {
                Character c = right.poll();
                if (c == null) {
                    break;
                }
                left.addLast(c);
            }
            return getString(left);
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorRight(6));

        System.out.println("TextEditor2:");
        TextEditor2 textEditor2 = new TextEditor2();
        textEditor2.addText("leetcode");
        System.out.println(textEditor2.deleteText(4));
        textEditor2.addText("practice");
        System.out.println(textEditor2.cursorRight(3));
        System.out.println(textEditor2.cursorLeft(8));
        System.out.println(textEditor2.deleteText(10));
        System.out.println(textEditor2.cursorRight(6));
    }
}
