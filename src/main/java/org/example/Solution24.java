package org.example;

import org.example.util.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Solution24 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            // 暂存下一个节点
            ListNode tmp = cur.next;
            // 修改当前节点的下一个指向为上一个节点(反转)
            cur.next = pre;
            // 将当前节点存为上一个节点
            pre = cur;
            // 访问下一个节点
            cur = tmp;
        }
        return pre;
    }
}
