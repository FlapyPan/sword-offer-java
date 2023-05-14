package org.example;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
 * <p>
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [3,4,5,1,2] 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：numbers = [2,2,2,0,1] 输出：0
 */
public class Solution11 {
    public int minArray(int[] numbers) {
        // 数组旋转次数只需要查找数组中最小的元素值即可
        // 使用最简单的线性查找
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
}
