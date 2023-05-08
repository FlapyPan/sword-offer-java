package org.example;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 */
public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return -1;
    }

    @Test
    public void test() {
        int result = findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        assert result == 2 || result == 3;
    }
}
