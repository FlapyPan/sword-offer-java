package org.example;

import org.example.util.ListNode;
import org.example.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void solution03Test() {
        int result = new Solution03().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        assertTrue(result == 2 || result == 3);
    }

    @Test
    public void solution04Test() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertTrue(new Solution04().findNumberIn2DArray(matrix, 5));
        assertFalse(new Solution04().findNumberIn2DArray(matrix, 20));
    }

    @Test
    public void solution05Test() {
        assertEquals("We%20are%20happy.", new Solution05().replaceSpace("We are happy."));
    }

    @Test
    public void solution06Test() {
        ListNode head = ListNode.fromArray(new int[]{1, 3, 2});
        assertArrayEquals(new Solution06().reversePrint(head), new int[]{2, 3, 1});
    }

    @Test
    public void solution07Test() {
        TreeNode treeNode = new Solution07().buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}
        );
    }

    @Test
    public void solution09Test() {
        var queue1 = new Solution09.CQueue();
        queue1.appendTail(3);
        assertEquals(queue1.deleteHead(), 3);
        assertEquals(queue1.deleteHead(), -1);
        assertEquals(queue1.deleteHead(), -1);
        var queue2 = new Solution09.CQueue();
        assertEquals(queue2.deleteHead(), -1);
        queue2.appendTail(5);
        queue2.appendTail(2);
        assertEquals(queue2.deleteHead(), 5);
        assertEquals(queue2.deleteHead(), 2);
    }

    @Test
    public void solution10_1Test() {
        var solution10_1 = new Solution10_1();
        assertEquals(solution10_1.fib(2), 1);
        assertEquals(solution10_1.fib(5), 5);
    }

    @Test
    public void solution10_2Test() {
        var solution10_2 = new Solution10_2();
        assertEquals(solution10_2.numWays(2), 2);
        assertEquals(solution10_2.numWays(7), 21);
        assertEquals(solution10_2.numWays(0), 1);
    }

    @Test
    public void solution11Test() {
        var solution11 = new Solution11();
        assertEquals(solution11.minArray(new int[]{3, 4, 5, 1, 2}), 1);
        assertEquals(solution11.minArray(new int[]{2, 2, 2, 0, 1}), 0);
    }

    @Test
    public void solution12Test() {
        var solution12 = new Solution12();
        assertTrue(solution12.exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        assertFalse(solution12.exist(new char[][]{
                new char[]{'a', 'b'},
                new char[]{'c', 'd'},
        }, "abcd"));
    }

    @Test
    public void solution13Test() {
        var solution13 = new Solution13();
        assertEquals(solution13.movingCount(2, 3, 1), 3);
        assertEquals(solution13.movingCount(3, 1, 0), 1);
    }

    @Test
    public void solution14_1Test() {
        var solution14_1 = new Solution14_1();
        assertEquals(solution14_1.cuttingRope(2), 1);
        assertEquals(solution14_1.cuttingRope(10), 36);
    }

    @Test
    public void solution14_2Test() {
        var solution14_2 = new Solution14_2();
        assertEquals(solution14_2.cuttingRope(2), 1);
        assertEquals(solution14_2.cuttingRope(10), 36);
    }

    @Test
    public void solution15Test() {
        var solution15 = new Solution15();
        assertEquals(solution15.hammingWeight(11), 3);
        assertEquals(solution15.hammingWeight(128), 1);
        assertEquals(solution15.hammingWeight(-3), 31);
    }

    @Test
    public void solution16Test() {
        var solution16 = new Solution16();
        assertEquals(solution16.myPow(2.00000, 10), 1024.00000);
        // 精度问题
        // assertEquals(solution16.myPow(2.10000, 3), 9.26100);
        assertEquals(solution16.myPow(2.00000, -2), 0.25000);
    }
}
