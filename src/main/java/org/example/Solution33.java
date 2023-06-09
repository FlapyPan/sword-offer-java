package org.example;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * <p>
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        /*
         * 先看二叉搜索树的性质（摘自百度百科）：
         *   1. 若任意结点的左子树不空，则左子树上所有结点的值均不大于它的根结点的值。
         *   2. 若任意结点的右子树不空，则右子树上所有结点的值均不小于它的根结点的值。
         *   3. 任意结点的左、右子树也分别为二叉搜索树。
         *
         * 思路：
         *   1. 从左往右迭代，依次获取当前结点的值
         *   2. 当前节点往左看，如果遇到比当前的值小的，就不能再遇到比它大的
         */
        boolean tag = false;
        for (int i = 0; i < postorder.length; i++) {
            int current = postorder[i];
            for (int j = i; j >= 0; j--) {
                int other = postorder[j];
                if (current > other) {
                    // 出现了比当前小的，记录下来
                    tag = true;
                }
                // 如果之前出现过小的值，蛋又出现了比当前结点大的值则为非法
                if (tag && current < other) return false;
            }
            tag = false;
        }
        return true;
    }
}
