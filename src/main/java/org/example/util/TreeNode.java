package org.example.util;

import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode fromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (node.val < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && node.val > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }


    public static TreeNode fromPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        return fromPostorder(postorder, 0, postorder.length - 1);
    }

    private static TreeNode fromPostorder(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[end]);
        int index = start;
        while (index < end && postorder[index] < root.val) {
            index++;
        }
        root.left = fromPostorder(postorder, start, index - 1);
        root.right = fromPostorder(postorder, index, end - 1);
        return root;
    }


}
