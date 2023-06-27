package org.example;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Solution50 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        // 统计每个字符的出现次数
        for (char c : chars) {
            count[c - 'a']++;
        }
        // 找到第一个只出现一次的字符
        for (char c : chars) {
            if (count[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
