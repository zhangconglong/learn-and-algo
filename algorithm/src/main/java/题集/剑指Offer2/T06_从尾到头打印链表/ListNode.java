package 题集.剑指Offer2.T06_从尾到头打印链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    /**
     * 方法一：暴力
     * <p>
     * 时间：O(N) * 3, 总共进行了三次遍历
     * 空间：O(N) * 3
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);

            head = head.next;

        }

        Collections.reverse(list);
        return list.stream().mapToInt((Integer i) -> i).toArray();
    }

    /**
     * 使用 栈
     * <p>
     * 时间：O(N) * 2
     * 空间：O(N) * 2
     */
    public int[] reversePrint_2(ListNode head) {
        Stack<Integer> stack = new Stack();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int len = stack.size();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = (int) stack.pop();
        }

        return arr;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        new Solution().reversePrint_2(node1);
    }
}