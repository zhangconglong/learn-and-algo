package 算法.二叉树.比较二叉树;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrder(p, q);
    }

    //先序遍历二叉树
    public boolean preOrder(TreeNode p, TreeNode q){
        //有一个为null
        if(p==null||q==null){
            return p == q;
        }
        //全不为null
        if(p.val==q.val){
            if(preOrder(p.left, q.left)&&preOrder(p.right, q.right))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

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
