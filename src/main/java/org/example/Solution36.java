package org.example;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/">完整题目</a>
 */
public class Solution36 {
    static class Node {
        public int val;
        public Node left, right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 头尾连接
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre == null) {
            // 如果pre为空，就说明是头结点，用head保存头结点
            head = cur;
        } else {
            // 如果不为空，那就说明是中间的节点，让上一个节点的右指针指向当前节点
            pre.right = cur;
        }
        // 再让当前节点的左指针指向父节点，连成了双向链表
        cur.left = pre;
        // 保存当前节点，用于下层递归创建
        pre = cur;
        dfs(cur.right);
    }
}
