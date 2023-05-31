package org.example;

import org.example.util.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
