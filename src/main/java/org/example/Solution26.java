package org.example;

import org.example.util.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * <p>
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * <p>
 * 输出：true
 */
public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        // 当前节点和的值相同检查子树，如果子树相同直接返回true
        if (A.val == B.val && isChild(A, B)) return true;
        // 左侧或右侧子树有一个包含即可
        if (isSubStructure(A.left, B)) return true;
        return isSubStructure(A.right, B);
    }

    /**
     * 判断子树是否相同
     */
    private boolean isChild(TreeNode A, TreeNode B) {
        // 如果找到了叶子节点
        if (A == null && B == null) return true;
        // 说明A下面有节点，而B没有节点
        if (A != null && B == null) return true;
        // A下没有节点，B一定不是A的子树
        if (A == null) return false;
        // 值不相等
        if (A.val != B.val) return false;
        // 递归检查左右子树
        return isChild(A.left, B.left) && isChild(A.right, B.right);
    }
}
