package org.example;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * <p>
 * 输出：3
 * <p>
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 128 (控制台输入 00000000000000000000000010000000)
 * <p>
 * 输出：1
 * <p>
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 4294967293 (控制台输入 11111111111111111111111111111101，部分语言中 n = -3）
 * <p>
 * 输出：31
 * <p>
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class Solution15 {
    public int hammingWeight(int n) {
        // 我用 java 摆烂了你的题
        // return Integer.bitCount(n);
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i) & 1;
        }
        return count;

    }
}