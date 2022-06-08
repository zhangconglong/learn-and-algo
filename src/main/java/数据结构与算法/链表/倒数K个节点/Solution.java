package 数据结构与算法.链表.倒数K个节点;

import java.util.*;

public class Solution {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        //放入栈中
        Deque<ListNode> stack = new ArrayDeque<>();
        stack.push(pHead);

        while (pHead.next != null){
            stack.push(pHead.next);
            pHead = pHead.next;
        }

        if(stack.size()<k){
            return null;
        }
        for (int i=0; i<k-1; i++) {
            stack.pop();
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        Solution solution = new Solution();
        ListNode listNode = solution.FindKthToTail(head1, 2);
        System.out.println(listNode.val);
    }
}

class ListNode {
  int val;
  ListNode next = null;
  public ListNode(int val) {
    this.val = val;
  }
}
