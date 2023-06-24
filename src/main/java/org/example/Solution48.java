package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        // 记录最大无重复子串长度
        int len = 0;
        // 用HashMap记录每个字符最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        // 左指针初始为-1，表示未开始遍历
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果c之前出现过，则更新左指针位置
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            // 更新c最后出现的位置
            map.put(c, i);
            // 更新最大无重复子串长度
            len = Math.max(len, i - left);
        }
        return len;
    }
}
