package org.example;

import org.example.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Solution32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // node 存储每一层的节点值
        List<List<Integer>> node = new ArrayList<>();
        level(node, root, 0);
        return node;
    }

    private void level(List<List<Integer>> node, TreeNode root, int i) {
        if (root == null) return;
        // 检查 node 中已有的层数
        if (node.size() <= i) node.add(new ArrayList<>());
        // 添加当前节点值
        node.get(i).add(root.val);
        // 递归处理左右子树
        level(node, root.left, i + 1);
        level(node, root.right, i + 1);
    }
}
