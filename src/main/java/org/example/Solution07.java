package org.example;

import org.example.util.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * <p>
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * <p>
 * Output: [-1]
 */
public class Solution07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(
            int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd
    ) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 每个子树的根节点是先序遍历的首个节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 查找根节点在中序遍历中的位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        // 获取中序遍历数组中，根节点左侧的节点数量
        int leftLen = index - inStart;
        // 递归构建左子树
        root.left = build(preorder, preStart + 1, preStart + leftLen, inorder, inStart, index - 1);
        // 递归构建右子树
        root.right = build(preorder, preStart + leftLen + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

}
