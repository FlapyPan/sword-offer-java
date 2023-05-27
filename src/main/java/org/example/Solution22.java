package org.example;

import org.example.util.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 快慢指针
        ListNode slow = head, fast = head;
        int t = 0; // 记录当前位置
        while (fast != null) {
            if (t >= k) slow = slow.next;
            fast = fast.next;
            t++;
        }
        return slow;
    }
}
