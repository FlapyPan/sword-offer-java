package org.example;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Solution21 {
    public int[] exchange(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) != 0) {
                if (a != i) {
                    int temp = nums[i];
                    nums[i] = nums[a];
                    nums[a] = temp;
                }
                a++;
            }
        }
        return nums;
    }
}
