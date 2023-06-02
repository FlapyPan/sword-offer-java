package org.example;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * <p>
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new int[0];
        int m = matrix[0].length;
        int left = 0; // 左边
        int right = m - 1; // 右边
        int top = 0; // 上边
        int bottom = n - 1; // 下边
        int[] res = new int[m * n];
        int x = 0;
        while (true) {
            // 从左往右
            for (int i = left; i <= right; i++) {
                res[x] = matrix[top][i];
                x += 1;
            }
            // 从左往右后往下走，上边界内缩
            top += 1;
            // 超出边界则退出
            if (top > bottom) break;
            // 从上往下
            for (int i = top; i <= bottom; i++) {
                res[x] = matrix[i][right];
                x += 1;
            }
            // 从上往下后往左走，右边界收缩
            right -= 1;
            // 超出边界则退出
            if (left > right) break;
            // 从右往左
            for (int i = right; i >= left; i--) {
                res[x] = matrix[bottom][i];
                x += 1;
            }
            // 从右往左后往上走，下边界收缩
            if (top > --bottom) break;
            // 从下往上
            for (int i = bottom; i >= top; i--) {
                res[x] = matrix[i][left];
                x += 1;
            }
            // 从下往上后往右走，左边界收缩
            left += 1;
            if (left > right) break;
        }
        return res;
    }
}
