package 数据结构与算法.二叉树.深度优先遍历.二叉树的最近公共子节点235;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return test(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    public TreeNode test(TreeNode root, int first, int last) {
        if(first==root.val||last==root.val)
            return root;
        else if(first<root.val&&last>root.val){//两侧
            return root;
        }
        if(last<root.val){//左侧
            return test(root.left, first, last);
        }else
            return test(root.right, first, last);
    }
}