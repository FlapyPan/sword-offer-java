package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 将数组转为链表
     */
    public static ListNode fromArray(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode cur = head;
        for (int i = 1; i < values.length; i++) {
            cur.next = new ListNode(values[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 将链表转为数组
     */
    public int[] toArray() {
        List<Integer> list = new ArrayList<>();
        ListNode cur = this;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
