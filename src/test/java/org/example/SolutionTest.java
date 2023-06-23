package org.example;

import org.example.util.ListNode;
import org.example.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    public void solution17Test() {
        var solution17 = new Solution17();
        System.out.println(Arrays.toString(solution17.printNumbers(1)));
    }

    @Test
    public void solution18Test() {
        var solution18 = new Solution18();
        ListNode head1 = ListNode.fromArray(new int[]{4, 5, 1, 9});
        head1 = solution18.deleteNode(head1, 5);
        assertArrayEquals(head1.toArray(), new int[]{4, 1, 9});
        ListNode head2 = ListNode.fromArray(new int[]{4, 5, 1, 9});
        head2 = solution18.deleteNode(head2, 1);
        assertArrayEquals(head2.toArray(), new int[]{4, 5, 9});
    }

    @Test
    public void solution19Test() {
        var solution19 = new Solution19();
        assertFalse(solution19.isMatch("aa", "a"));
        assertTrue(solution19.isMatch("aa", "a*"));
        assertTrue(solution19.isMatch("ab", ".*"));
        assertTrue(solution19.isMatch("aab", "c*a*b"));
        assertFalse(solution19.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    public void solution20Test() {
        var solution20 = new Solution20();
        assertTrue(solution20.isNumber("0"));
        assertFalse(solution20.isNumber("e"));
        assertFalse(solution20.isNumber("."));
        assertTrue(solution20.isNumber("    .1  "));
        assertTrue(solution20.isNumber("+100"));
        assertTrue(solution20.isNumber("5e2"));
        assertTrue(solution20.isNumber("-123"));
        assertTrue(solution20.isNumber("-1E-16"));
        assertFalse(solution20.isNumber("1a3.14"));
        assertFalse(solution20.isNumber("1.2.3"));
        assertFalse(solution20.isNumber("+-5"));
        assertFalse(solution20.isNumber("12e+5.4"));
    }

    @Test
    public void solution21Test() {
        var solution21 = new Solution21();
        System.out.println(Arrays.toString(solution21.exchange(new int[]{1, 2, 3, 4})));
    }

    @Test
    public void solution22Test() {
        var solution22 = new Solution22();
        ListNode result = solution22.getKthFromEnd(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2);
        assertArrayEquals(result.toArray(), new int[]{4, 5});
    }

    @Test
    public void solution24Test() {
        var solution24 = new Solution24();
        ListNode reversedList = solution24.reverseList(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(reversedList.toArray(), new int[]{5, 4, 3, 2, 1});
    }

    @Test
    public void solution25Test() {
        var solution25 = new Solution25();
        ListNode node = solution25.mergeTwoLists(
                ListNode.fromArray(new int[]{1, 2, 4}),
                ListNode.fromArray(new int[]{1, 3, 4})
        );
        assertArrayEquals(node.toArray(), new int[]{1, 1, 2, 3, 4, 4});
    }

    @Test
    public void solution26Test() {
        var solution26 = new Solution26();
        assertFalse(solution26.isSubStructure(
                TreeNode.fromBfsArray(new int[]{1, 2, 3}),
                TreeNode.fromBfsArray(new int[]{3, 1})
        ));
        assertTrue(solution26.isSubStructure(
                TreeNode.fromBfsArray(new int[]{3, 4, 5, 1, 2}),
                TreeNode.fromBfsArray(new int[]{4, 1})
        ));
    }

    @Test
    public void solution27Test() {
        var solution27 = new Solution27();
        int[] result = solution27.mirrorTree(
                TreeNode.fromBfsArray(new int[]{4, 2, 7, 1, 3, 6, 9})
        ).toBfsArray();
        assertArrayEquals(new int[]{4, 7, 2, 9, 6, 3, 1}, result);
    }

    @Test
    public void solution28Test() {
        var solution28 = new Solution28();
        assertTrue(solution28.isSymmetric(TreeNode.fromBfsArray(new int[]{1, 2, 2, 3, 4, 4, 3})));
    }

    @Test
    public void solution29Test() {
        var solution29 = new Solution29();
        assertArrayEquals(
                new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5},
                solution29.spiralOrder(new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9},
                })
        );
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7},
                solution29.spiralOrder(new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12},
                })
        );
    }

    @Test
    public void solution30Test() {
        var stack = new Solution30();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3, stack.min());
        stack.pop();
        assertEquals(0, stack.top());
        assertEquals(-2, stack.min());
    }

    @Test
    public void solution31Test() {
        var s = new Solution31();
        assertTrue(s.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        assertFalse(s.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    @Test
    public void solution33Test() {
        var s = new Solution33();
        assertFalse(s.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        assertTrue(s.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    @Test
    public void solution37Test() {
        var s = new Solution37();
        String target = "1 2 # # 3 4 # # 5 # #";
        TreeNode node = s.deserialize(target);
        String serialized = s.serialize(node);
        assertEquals(serialized, target);
    }

    @Test
    public void solution38Test() {
        var s = new Solution38();
        System.out.println(Arrays.toString(s.permutation("abc")));
        System.out.println(Arrays.toString(s.permutation("123456")));
    }

    @Test
    public void solution39Test() {
        var s = new Solution39();
        assertEquals(2, s.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    @Test
    public void solution41Test() {
        var s = new Solution41();
        assertEquals(0.0, s.findMedian());
        s.addNum(1);
        s.addNum(2);
        assertEquals(1.5, s.findMedian());
        s.addNum(3);
        assertEquals(2.0, s.findMedian());
    }

    @Test
    public void solution42Test() {
        var s = new Solution42();
        assertEquals(6, s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void solution43Test() {
        var s = new Solution43();
        assertEquals(5, s.countDigitOne(12));
    }

    @Test
    public void solution44Test() {
        var s = new Solution44();
        assertEquals(3, s.findNthDigit(3));
        assertEquals(0, s.findNthDigit(11));
        assertEquals(9, s.findNthDigit(1145141919));
    }

    @Test
    public void solution45Test() {
        var s = new Solution45();
        assertEquals("102", s.minNumber(new int[]{10, 2}));
        assertEquals("3033459", s.minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    public void solution46Test() {
        var s = new Solution46();
        assertEquals(5, s.translateNum(12258));
    }

    @Test
    public void solution47Test() {
        var s = new Solution47();
        assertEquals(12, s.maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}
