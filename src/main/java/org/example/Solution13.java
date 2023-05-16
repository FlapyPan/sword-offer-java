package org.example;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0 输出：1
 */
public class Solution13 {
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) return 0;
        if (k == 0) return 1;
        // 一维数组模拟二维数组
        return count(new boolean[m * n], m, n, 0, 0, k);
    }

    private int count(boolean[] flag, int m, int n, int i, int j, int k) {
        if (!accessible(flag, m, n, i, j, k)) return 0;
        // 标记当前方格已经访问过
        flag[i * n + j] = true;
        // 往四个方向运动, 只需要往右下运动
        return 1
                // + count(flag, m, n, i - 1, j, k)
                + count(flag, m, n, i + 1, j, k)
                // + count(flag, m, n, i, j - 1, k)
                + count(flag, m, n, i, j + 1, k);
    }

    private boolean accessible(boolean[] flag, int m, int n, int i, int j, int k) {
        // 越界
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        // 已经访问过
        if (flag[i * n + j]) return false;
        // 检查总和
        int total = 0;
        while (i > 0) {
            total += i % 10;
            i /= 10;
        }
        if (k < total) return false;
        while (j > 0) {
            total += j % 10;
            j /= 10;
        }
        return k >= total;
    }
}
