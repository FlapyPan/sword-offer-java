package org.example;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * <p>
 * [[],[3],[],[],[]]
 * <p>
 * 输出：[null,null,3,-1,-1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * <p>
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * <p>
 * [[],[],[5],[2],[],[]]
 * <p>
 * 输出：[null,-1,null,null,5,2]
 */
public class Solution09 {
    public static class CQueue {
        private final Deque<Integer> A, B;

        public CQueue() {
            A = new LinkedList<>();
            B = new LinkedList<>();
        }

        public void appendTail(int value) {
            A.addLast(value);
        }

        public int deleteHead() {
            if (B.size() > 0) return B.removeLast();
            if (A.size() == 0) return -1;
            while (A.size() > 0) {
                B.addLast(A.removeLast());
            }
            return B.removeLast();
        }
    }
}
