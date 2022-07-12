package 面试题.Y2022春招.网易.网易.第一题;

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
  public TreeNode(int val) {
    this.val = val;
  }
}

public class Solution {
    public boolean isSubtree (TreeNode s, TreeNode t) {
        //遍历树
        return inOrder(s, t);
    }


    //递归，判断子树是否相同
    public boolean backtrack(TreeNode s, TreeNode t, boolean flag) {
        if (flag) return false;

        //判断左右节点是否相同
        if(s==null&&t==null){
            return true;
        }else if(s!=null&&t!=null){
            //左子节点
            backtrack(s.left, t.left, true);
            backtrack(s.left, t.left, true);
        }else {
            return false;
        }
        return true;
    }

    //遍历二叉树s
    public boolean inOrder (TreeNode s, TreeNode t){
        if(s.val==t.val){
            if (backtrack(s, t.left, true)) return true;
            inOrder(s, t);
        }
        //先序遍历
        if(s.left!=null){
            if(s.left.val==t.val){
                if (backtrack(s.left, t.left, true)) return true;
            }
            inOrder(s.left, t);
        }
        if(s.right!=null){
            if(s.right.val==t.val){
                if (backtrack(s.right, t.left, true)) return true;
            }
            inOrder(s.right, t);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);

        TreeNode s1 = new TreeNode(4);
        TreeNode s2 = new TreeNode(1);
        TreeNode s3 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        s1.left = s2;
        s1.right = s3;

        System.out.println(new Solution().isSubtree(t1, s1));
    }
}
