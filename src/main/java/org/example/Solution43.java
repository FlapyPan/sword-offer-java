package org.example;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class Solution43 {
    public int countDigitOne(int n) {
        int base = 1;  // 当前位数，从 1 开始，类似于 1、10、100、1000...
        int count = 0;
        int round = n;  // 当前位置左边的数字，用于计算当前的数量
        while (round > 0) {
            int digit = round % 10;  // 当前位置上的数字
            round /= 10;  // 往右移动一位
            // 计算当前位置上数字 1 的数量
            count += round * base;  // 如果当前位为 0 或者更大的数字，都会出现 1
            if (digit == 1) {
                // 如果当前位为 1，需要特殊处理
                count += n % base + 1;  // 1 的个数就是当前位置右边的数字加上 1
            } else if (digit > 1) {
                // 如果当前位大于 1，也需要特殊处理
                count += base;  // 1 的个数就是 base
            }
            // 更新 base 的值
            base *= 10;
        }
        return count;
    }

}
