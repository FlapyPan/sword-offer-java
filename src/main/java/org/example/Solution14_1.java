package org.example;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2 输出: 1
 * <p>
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10 输出: 36
 * <p>
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class Solution14_1 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        // 3最接近自然底数e，理想划分：3*3*3...
        int countOf3 = n / 3;
        // 判断是否整除
        int rem = n % 3;
        if (rem == 0) {
            // 整除
            return (int) Math.pow(3, countOf3);
        } else if (rem == 1) {
            // 剩下1, ...3*3*1优化为...3*2*2
            return (int) Math.pow(3, countOf3 - 1) * 2 * 2;
        } else {
            // 剩下2
            return (int) Math.pow(3, countOf3) * 2;
        }
    }
}
