package org.example;

import org.example.util.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode n1 = headA;  // 遍历链表 A 的指针
        ListNode n2 = headB;  // 遍历链表 B 的指针
        while (n1 != n2) {
            // 若遍历到了链表末尾，则指针指向另一个链表的头节点
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }

}
