package org.example;

import org.example.util.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 */
public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode node = head;
        while (node.next != null && node.next.val != val) {
            node = node.next;
        }
        if (node.next != null) {
            node.next = node.next.next;
        }
        return head;
    }
}
