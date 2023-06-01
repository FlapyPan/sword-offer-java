package org.example.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public int[] toBfsArray() {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    public static TreeNode fromBfsArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode current = queue.poll();
            if (i < nums.length) {
                if (nums[i] != -1) {  // -1 表示空节点
                    current.left = new TreeNode(nums[i]);
                    queue.offer(current.left);
                }
                i++;
            }
            if (i < nums.length) {
                if (nums[i] != -1) {  // -1 表示空节点
                    current.right = new TreeNode(nums[i]);
                    queue.offer(current.right);
                }
                i++;
            }
        }
        return root;
    }

}
