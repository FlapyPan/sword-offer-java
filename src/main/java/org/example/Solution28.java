package org.example;

import org.example.util.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 看到二叉树，基本上就是经典的 bfs
        return bfs(root.left, root.right);
    }

    private boolean bfs(TreeNode root1, TreeNode root2) {
        // 两个都为空，则是对称的
        if (root1 == null && root2 == null) return true;
        // 只要有一个为空，就不是对称的
        if (root1 == null || root2 == null) return false;
        // 值不相等则不对称
        if (root1.val != root2.val) return false;
        // 递归检查子节点
        return bfs(root1.left, root2.right) && bfs(root1.right, root2.left);
    }
}
