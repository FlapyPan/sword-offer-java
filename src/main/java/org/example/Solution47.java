package org.example;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。<p>
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。<p>
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class Solution47 {
    public int maxValue(int[][] grid) {
        /// 经典的dp
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];  // dp矩阵
        // 外部循环遍历矩阵的每一行
        for (int i = 0; i < m; i++) {
            // 内部循环遍历矩阵的每一列
            for (int j = 0; j < n; j++) {
                // 计算当前位置的最大价值，需要根据上一个位置和左边一个位置的最大价值来得出
                // 如果j等于0，则左边没有位置，preX设为0；否则，preX设为dp[i][j - 1]
                int preX = j > 0 ? dp[i][j - 1] : 0;
                // 如果i等于0，则上面没有位置，preY设为0；否则，preY设为dp[i - 1][j]
                int preY = i > 0 ? dp[i - 1][j] : 0;
                // 当前位置的最大价值为上一个位置和左边一个位置的最大价值中较大的那个再加上当前位置的价值
                dp[i][j] = Math.max(preX, preY) + grid[i][j];
            }
        }
        // 返回右下角位置的最大价值
        return dp[m - 1][n - 1];
    }

}
