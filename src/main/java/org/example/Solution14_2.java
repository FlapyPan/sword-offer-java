package org.example;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
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
public class Solution14_2 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        // 最接近自然底数e的整数是3，所以最理想的划分是 3*3*3*3...
        int x = 3;
        // 模
        int p = 1000000007;
        // 获取按3划分后余数
        int rem = n % x;
        // 获取准确的个数：如果余数为1，需要把3*1变成2*2
        int num = rem == 1 ? (n / x) - 1 : n / x;
        // 结合循环余数公式，求出所有3的乘积
        long result = 1;
        for (int i = 0; i < num; i++) {
            result = (result * x) % p;
        }
        if (rem == 0) {
            // 整除
            return (int) result;
        } else if (rem == 1) {
            // 剩下一段1，优化成 ...3*2*2
            return (int) ((result * 4) % p);
        } else {
            // 剩下一段2，直接乘
            return (int) ((result * 2) % p);
        }

    }
}
