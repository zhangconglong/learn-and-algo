package 算法.二叉树.层次遍历.层次遍历102;

import java.util.*;

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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> res =  new ArrayList<>();

        TreeNode cur;
        queue.add(root);//第一层

        while (queue.size()!=0){
            int sz = queue.size();//获取该层节点数
            List<Integer> levelRes = new ArrayList<>();

            for (int i = 0; i < sz; i++) {
                cur = queue.poll();//该层的节点，依次弹出
                assert cur != null;
                levelRes.add(cur.val);

                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            res.add(levelRes);
        }
        return res;
    }
}
