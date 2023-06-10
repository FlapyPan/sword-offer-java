package org.example;

import org.example.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从<b>根节点</b>到<b>叶子节点</b> 路径总和等于给定目标和的路径。
 */
public class Solution34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // 经典的二叉树，依旧的 dfs
        // path 用来存储每条可能路径
        Deque<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, target, path, result);
        return result;
    }

    private void dfs(TreeNode root, int target, Deque<Integer> path, List<List<Integer>> result) {
        if (root == null) return;
        // 把当前节点的值放入路径中
        int val = root.val;
        path.addLast(val);
        // 减去当前节点的值，剩下的就是
        target -= val;
        if (root.left == null && root.right == null && target == 0) {
            // 如果当前是叶子节点(没有 left 和 right)，而且 target 只剩下了0
            // 表示当前路径可行，复制一份放进去
            // 这里一定要复制，后续包括其他的 dfs 还需要用到 path
            result.add(new ArrayList<>(path));
        } else {
            // 往下找
            dfs(root.left, target, path, result);
            dfs(root.right, target, path, result);
        }
        // 无论当前路径是否有效，都需要把当前节点给移除
        path.removeLast();
    }
}
