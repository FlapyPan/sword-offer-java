package org.example;

import org.example.util.TreeNode;

import java.util.Collections;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 * <p>
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Solution32_2 s = new Solution32_2();
        // 直接用上一题的结果，然后双数层翻转一下 :p
        List<List<Integer>> lists = s.levelOrder(root);
        for (int i = 1; i < lists.size(); i += 2) {
            Collections.reverse(lists.get(i));
        }
        return lists;
    }
}
