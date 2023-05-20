package org.example;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn），不得使用库函数
 */
public class Solution16 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        // 快速幂
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b = b >> 1;
        }
        return res;
    }
}
