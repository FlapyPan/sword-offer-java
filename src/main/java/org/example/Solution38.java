package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 */
public class Solution38 {
    public String[] permutation(String s) {
        // 经典的全排列，直接使用一个简单的方法：交换字符生成和Set 去重
        Set<String> set = new HashSet<>();
        dfs(set, s.toCharArray(), 0);
        return set.toArray(new String[0]);
    }

    private void dfs(Set<String> set, char[] chars, int index) {
        if (index == chars.length) {
            set.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            dfs(set, chars, index + 1);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
