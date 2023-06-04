package org.example;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * <p>
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列
 */
public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 辅助栈
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        for (int n : pushed) {
            deque.push(n);
            // 循环出栈
            while (!deque.isEmpty() && deque.peek() == popped[i]) {
                // 如果辅助栈弹出的元素与pooped序列i所指向的元素相等，弹出辅助栈对应的元素
                deque.pop();
                i += 1;
            }
        }
        // 如果辅助栈没弹干净，则说明是非法的弹出序列
        return deque.isEmpty();
    }
}
