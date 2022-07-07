package 面试题.网易.网易.第二题;

import java.util.ArrayList;
import java.util.List;

class ListNode {
  int val;
  ListNode next = null;
  public ListNode(int val) {
    this.val = val;
  }
}

public class Solution {
    //返回中间节点
    public ListNode middleNode (ListNode head) {
        //
        List<ListNode> list = new ArrayList();
        list.add(head);
        int count = 1;
        while(head.next!=null){
            head = head.next;
            list.add(head);
            count++;
        }
//        if(count%2==1){//偶数
//            return list.get(count/2);
//        }
        return list.get(count/2);
    }

    public static void main(String[] args) {

    }
}
