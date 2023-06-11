package org.example;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next, random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * <p>
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Solution35 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // map 存储每个 node 以及对应的新的拷贝
        Map<Node, Node> map = new HashMap<>();
        // 拷贝所有 node
        for (Node node = head; node != null; node = node.next) {
            map.put(node, new Node(node.val));
        }
        // 将 next 和 random 连接上
        for (Node node = head; node != null; node = node.next) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(head);
    }
}
