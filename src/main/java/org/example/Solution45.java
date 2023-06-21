package org.example;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Solution45 {
    public String minNumber(int[] nums) {
        // 创建一个与传入的数组长度相等的字符串数组
        String[] strNums = new String[nums.length];
        // 遍历传入的数组，将每个元素转化成字符串类型
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        //使用 Arrays.sort 方法对 strNums 数组进行排序，自定义比较器先将 s1+s2 和 s2+s1 拼接起来再比较大小，将结果由小到大排序
        Arrays.sort(strNums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        //创建一个 StringBuilder 对象
        StringBuilder builder = new StringBuilder();
        //遍历已排序好的 strNums 数组，将每个字符串追加到 sb 中
        for (String str : strNums) {
            builder.append(str);
        }
        //将 builder 转换成字符串并返回
        return builder.toString();
    }


}
