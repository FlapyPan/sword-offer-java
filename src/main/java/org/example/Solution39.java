package org.example;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution39 {
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        int count = 0, result = 0;
        for (int num : nums) {
            if (count == 0) {
                // 如果上一个投票数量为 0，表示上一位被淘汰
                // 把当前的 num 放入 result 进行投票
                result = num;
            }
            if (result == num) {
                // 遇到一样的 num，选票++
                count += 1;
            } else {
                // 不一样就--
                count -= 1;
            }
        }
        return result;
    }
}
