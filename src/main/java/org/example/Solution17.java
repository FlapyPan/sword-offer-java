package org.example;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * <p>
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class Solution17 {
    public int[] printNumbers(int n) {
//        return IntStream.range(1, (int) Math.pow(10, n)).toArray();
        int[] result = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

}
