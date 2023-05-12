package org.example;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5 输出：5
 */
public class Solution10_1 {
    public int fib(int n) {
        if (n < 0) return -1;
        if (n < 2) return n;
        // 结合循环取余公式
        int n1 = 1, n2 = 0;
        for (int i = 2; i <= n; ++i) {
            int tmp = n2 % 1000000007;
            n2 = n1 % 1000000007;
            n1 = (tmp + n1) % 1000000007;
        }
        return n1;
    }
}
