package 数据结构与算法.二叉树.层次遍历.二叉树的锯齿形层次遍历103;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //使用双向队列
        if(root==null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        short temp = 0;//偶数向右，奇数向左
        //层次遍历
        while (deque.size()!=0){
            int size = deque.size();//该层节点数
            TreeNode node ;
            List<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++) {
                if(temp%2==1){//最后一个，从右往左
                    node = deque.removeLast();
                    list.add(node.val);
                    if(node.right!=null) deque.addFirst(node.right);//先右
                    if(node.left!=null) deque.addFirst(node.left);//后左
                }
                else {//第一个，从左往右
                    node = deque.removeFirst();
                    list.add(node.val);
                    if(node.left!=null) deque.addLast(node.left);//先左
                    if(node.right!=null) deque.addLast(node.right);//后右
                }
            }
            res.add(list);
            temp++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        TreeNode root = new TreeNode(3);
//        TreeNode root9 = new TreeNode(9);
//        TreeNode root20 = new TreeNode(20);
//        TreeNode root15 = new TreeNode(15);
//        TreeNode root7 = new TreeNode(7);
//        root.left = root9;
//        root.right=root20;
//
//        root20.left=root15;
//        root20.right=root7;

        List<List<Integer>> lists = new Solution().zigzagLevelOrder(root);
        lists.forEach(System.out::println);
    }
}
