package org.example;

import org.example.util.TreeNode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class Solution37 {
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return (root.val + " " + serialize(root.left) + " " + serialize(root.right)).trim();
    }

    private int i;

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] split = data.split(" ");
        if (split.length == 0) return null;
        i = 0;
        return deserializeDfs(split);
    }

    private TreeNode deserializeDfs(String[] split) {
        String sub = split[i];
        i += 1;
        if ("#".equals(sub)) return null;
        int val = Integer.parseInt(sub);
        TreeNode root = new TreeNode(val);
        root.left = deserializeDfs(split);
        root.right = deserializeDfs(split);
        return root;
    }
}
