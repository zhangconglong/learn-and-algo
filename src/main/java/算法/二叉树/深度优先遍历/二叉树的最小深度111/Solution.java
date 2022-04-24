package 算法.二叉树.深度优先遍历.二叉树的最小深度111;

import java.util.Deque;
import java.util.LinkedList;

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

/**
 * 思路讲解：使用二叉树的层次遍历
 * 再某一层发现叶子节点，直接返回
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Deque<TreeNode> queue = new LinkedList<>();//每一层的队列
        queue.addLast(root);
        int minDepth = 0;

        //层次遍历
        while (!queue.isEmpty()){
            int size = queue.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left==null&&node.right==null)
                    return  minDepth;

                if(node.left!=null){
                    queue.addLast(node.left);
                }
                if (node.right!=null)
                    queue.addLast(node.right);
            }
        }

        return minDepth;
    }
}