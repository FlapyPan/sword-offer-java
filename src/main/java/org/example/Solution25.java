package org.example;

import org.example.util.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * <p>
 * 输出：1->1->2->3->4->4
 */
public class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }

        ListNode node = l1.val < l2.val ? l1 : l2;
        node.next = mergeTwoLists(node.next, l1.val >= l2.val ? l1 : l2);

        return node;
    }
}
