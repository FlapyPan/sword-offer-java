package org.example;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。<p>
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
 */
public class Solution46 {
    public int translateNum(int num) {
        /// 面向结果编程 :p
        // 当num为[0,9]时，只有一种翻译方式
        if (num <= 9) return 1;
        // 当num为[10, 25]时，有两种翻译方式
        if (num <= 25) return 2;
        // 当num为(25, 100)时，降低一位递归计算
        if (num < 100) return translateNum(num / 10);
        // num >= 100 时，暂时不考虑最后两位数的情况，降低一位递归计算
        int res = translateNum(num / 10);
        // 再判断最后两位数能否被翻译，加上数量
        if (num % 100 <= 25 && num % 100 >= 10) {
            res += translateNum(num / 100);
        }
        return res;
    }
}
