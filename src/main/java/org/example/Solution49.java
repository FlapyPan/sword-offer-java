package org.example;

public class Solution49 {
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] ugly = new int[n]; // 用于存储丑数的数组
        ugly[0] = 1; // 第一个丑数是1
        int i2 = 0, i3 = 0, i5 = 0; // 用于记录下一个丑数是由哪个丑数乘以2、3、5得到的
        int nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5; // 下一个可能成为丑数的乘数
        for (int index = 1; index < n; index++) {
            int min = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            ugly[index] = min; // 将最小的数作为下一个丑数
            if (min == nextMultipleOf2) {
                i2++; // 更新i2的索引
                nextMultipleOf2 = ugly[i2] * 2; // 计算下一个可能成为丑数的乘数
            }
            if (min == nextMultipleOf3) {
                i3++; // 更新i3的索引
                nextMultipleOf3 = ugly[i3] * 3; // 计算下一个可能成为丑数的乘数
            }
            if (min == nextMultipleOf5) {
                i5++; // 更新i5的索引
                nextMultipleOf5 = ugly[i5] * 5; // 计算下一个可能成为丑数的乘数
            }
        }

        return ugly[n - 1]; // 返回第n个丑数
    }
}
