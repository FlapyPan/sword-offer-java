package org.example;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Solution51 {
    public int reversePairs(int[] nums) {
        /// 归并排序
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        // 合并两个有序数组
        int[] merged = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (nums[j] < nums[i]) {
                // 若右半部分的元素小于左半部分的元素，则构成逆序对
                count += mid - i + 1;
                merged[k++] = nums[j++];
            } else {
                merged[k++] = nums[i++];
            }
        }
        // 处理剩余的元素
        while (i <= mid) merged[k++] = nums[i++];
        while (j <= end) merged[k++] = nums[j++];
        // 将合并后的数组复制回原数组
        System.arraycopy(merged, 0, nums, start, end - start + 1);
        return count;
    }

}
