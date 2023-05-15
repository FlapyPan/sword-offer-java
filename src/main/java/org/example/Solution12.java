package org.example;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * <p>
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * <p>
 * 输出：false
 */
public class Solution12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, i, j, chars, 0)) return true;
            }
        }
        return false;
    }

    private boolean check(char[][] board, int i, int j, char[] chars, int k) {
        // 越界
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return false;
        // 检查匹配情况
        if (board[i][j] != chars[k]) return false;
        // 匹配完毕
        if (k == chars.length - 1) return true;
        // 标记访问状态
        board[i][j] = 0;

        boolean result = check(board, i - 1, j, chars, k + 1) // 检查上
                || check(board, i + 1, j, chars, k + 1) // 检查下
                || check(board, i, j - 1, chars, k + 1) // 检查左
                || check(board, i, j + 1, chars, k + 1); // 检查右
        // 恢复标记状态
        board[i][j] = chars[k];
        return result;
    }
}
