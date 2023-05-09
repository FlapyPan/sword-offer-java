package org.example;

import org.example.util.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]  输出：[2,3,1]
 */
public class Solution06 {
    private int[] res = null;
    private int count = 0;
    private int i = 0;

    public int[] reversePrint(ListNode head) {
        solve(head);
        return res;
    }

    public void solve(ListNode head) {
        if (head == null) {
            // 如果当前节点为 null，表示已经遍历完成
            // 使用存储的 count 初始化数组
            res = new int[count];
            return;
        }
        // 不为 null 则 count 加一
        count += 1;
        // 在递归所有节点后再设置值
        // 这里利用了递归函数调用栈的特点：先进后出、后进先出，最后弹出栈的节点是最先设置值的
        solve(head.next);
        res[i] = head.val;
        i += 1;
    }

    @Test
    public void test() {
        ListNode head = ListNode.fromArray(new int[]{1, 3, 2});
        assert Arrays.equals(reversePrint(head), new int[]{2, 3, 1});
    }
}
