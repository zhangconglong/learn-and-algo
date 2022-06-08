package 数据结构与算法.二叉树.深度优先遍历.恢复二叉树99;

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
 * 两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * https://leetcode-cn.com/problems/recover-binary-search-tree/solution/san-chong-jie-fa-xiang-xi-tu-jie-99-hui-fu-er-cha-/
 */
//class Solution {
//    public void recoverTree(TreeNode root) {
//        List<TreeNode> list = new ArrayList<TreeNode>();
//
//        dfs(root,list);
//
//        TreeNode x = null;
//        TreeNode y = null;
//
//        //扫面遍历的结果，找出可能存在错误交换的节点x和y
//        for(int i=0;i<list.size()-1;++i) {
//            if(list.get(i).val>list.get(i+1).val) {
//                y = list.get(i+1);
//                if(x==null) {
//                    x = list.get(i);
//                }
//            }
//        }
//        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
//        if(x!=null && y!=null) {
//            int tmp = x.val;
//            x.val = y.val;
//            y.val = tmp;
//        }
//    }
//
//    //中序遍历二叉树，并将遍历的结果保存到list中
//    private void dfs(TreeNode node, List<TreeNode> list) {
//        if(node==null) {
//            return;
//        }
//        dfs(node.left,list);
//        list.add(node);
//        dfs(node.right,list);
//    }
//}
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode before = null;
        TreeNode first = null;
        TreeNode second = null;
        while (root != null) {
            //当左子树不为null，寻找左子树的最右节点，该节点为中序遍历中的前一个节点
            if (root.left != null) {
                TreeNode pre = getPredecessor(root);
                //pre节点没被修改，则修改右节点为root，以便后续循环中能通过pre.right回到root节点
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                    //继续遍历左子树
                    continue;
                } else if (pre.right == root) {
                    //将修改后的pre节点恢复原样
                    pre.right = null;
                }
            }
            //当左子树为null，或者pre.right为root时，先判断before节点和root节点是否倒序，然后再遍历右子树
            if (first == null && before != null && before.val > root.val)
                first = before;
            if (first != null && before != null && before.val > root.val)
                second = root;
            before = root;
            root = root.right;
        }
        swap(first, second);
    }
    //寻找一个节点的左子树的最右节点
    private TreeNode getPredecessor(TreeNode n) {
        TreeNode pre = n;
        if (n.left != null) {
            pre = pre.left;
            while (pre.right != null && pre.right != n) {
                pre = pre.right;
            }
        }
        return pre;
    }
    //交换两个节点
    private void swap(TreeNode first, TreeNode second) {
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
