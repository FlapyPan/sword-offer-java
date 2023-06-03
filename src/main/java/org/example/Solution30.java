package org.example;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Solution30 {
    // min 记录最小值
    private long min;

    /// 为什么要自己写个栈呢，直接用不好吗 :p
    /// 这个栈只用于记录每个值和 min 的差值
    private final Deque<Long> stack = new LinkedList<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            min = Math.min(min, x);
        }
    }

    public void pop() {
        Long peeked = stack.peek();
        if (peeked == null) return;
        if (peeked < 0) {
            min = min - peeked;
        }
        stack.pop();
    }

    public int top() {
        Long peeked = stack.peek();
        if (peeked < 0) return (int) min;
        else return (int) (peeked + min);
    }

    public int min() {
        return (int) min;
    }
}
