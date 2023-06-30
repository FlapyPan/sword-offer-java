package org.example;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution53_1 {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        int low = 0, high = len - 1;
        // 使用二分查找法
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                // 找到目标值时，检查前后两个元素是否也等于目标值
                // 若不等于，则更新边界值，继续搜索
                if (nums[high] != target)
                    high--;
                else if (nums[low] != target)
                    low++;
                else
                    break;
            }
        }
        return high - low + 1;
    }

}
