package org.example;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 提示：-100 <= arr[i] <= 100
 */
public class Solution42 {
    public int maxSubArray(int[] nums) {
        // 贪心法
        int max = -101; // 题目规定的数字范围 [-100,100]
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
