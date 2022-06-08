package 数据结构与算法.二叉树.层次遍历.二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return  new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = null;
        queue.add(root);

        while (queue.size()!=0){
            int levelSize = queue.size();//要遍历的节点数

            for (int i = 0; i < levelSize; i++) {
                cur = queue.poll();

                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            res.add(cur.val);
        }

        return res;
    }
}
