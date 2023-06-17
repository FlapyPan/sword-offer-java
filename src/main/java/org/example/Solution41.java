package org.example;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * <p>
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Solution41 {
    // 大顶堆存储比一半大的值
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // 小顶堆存储比一半小的值
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        if (maxHeap.size() != minHeap.size()) {
            // 奇数时先放入小顶堆 重新排序后在插入到大顶堆
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            // 偶数时先放入大顶堆 重新排序后在插入到小顶堆
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (minHeapSize == 0) return 0.0;
        if (maxHeapSize == minHeapSize) {
            // 偶数时取大顶堆最小的一个和小顶堆的最大一个，进行平均运算
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // 奇数直接从小顶堆取最大的一个
            return minHeap.peek();
        }
    }

}
