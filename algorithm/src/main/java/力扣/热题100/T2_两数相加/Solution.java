package 力扣.热题100.T2_两数相加;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res_header = new ListNode(0);//结果的头结点
        ListNode res = res_header;//存储结果的链表

        int carry = 0;//【前两个节点和】的进位

        while (l1 != null || l2 != null || carry != 0) {
            //要进行计算的两个节点
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            int sumVal = l1Val + l2Val + carry;

            carry = sumVal / 10; //进位
            ListNode sumNode = new ListNode(sumVal % 10); //
            res.next = sumNode;
            res = sumNode;

            //继续向下遍历
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return res_header.next;
    }
}