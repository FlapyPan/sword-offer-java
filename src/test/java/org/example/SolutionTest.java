package org.example;

import org.example.util.ListNode;
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
}
