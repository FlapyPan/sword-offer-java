package org.example;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 */
public class Solution44 {
    public int findNthDigit(int n) {
        // 将n转换成long类型，以避免整数溢出
        long num = n;
        // 数字所在的数位数，默认为1（一位数）
        int digit = 1;
        // 当前数位的起始数字，比如一位数从1开始，两位数从10开始
        long start = 1;
        // 当前数位数包含的所有数字总数，比如一位数包含9个数字，两位数包含90个数字
        long count = 9;

        // 循环计算num所在的数位数，并得到其余数m
        while (num > count * digit) {
            num -= count * digit;
            digit++; // 数位数加1
            start *= 10; // 起始数字扩大10倍
            count *= 10; // 包含数字总数扩大10倍
        }

        // 计算目标数字，即第(m-1)/digit个digit位数中的数字
        long targetNum = start + (num - 1) / digit;
        // 将数值转化为字符串，方便获取对应位置上的字符
        String s = Long.toString(targetNum);
        // 获取对应位置上的数字并返回
        char c = s.charAt((int) ((num - 1) % digit));
        return Character.getNumericValue(c);
    }

}
