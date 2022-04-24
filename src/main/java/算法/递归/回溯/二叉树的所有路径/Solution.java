package 算法.递归.回溯.二叉树的所有路径;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        Stack<String> stack = new Stack<String>();
        back(root, stack);
        return res;
    }

    /**
    * node：
    * ：表示第几条路径
    * 路径条数 == 叶子节点个数
    */
    public void back(TreeNode root, Stack<String> stack){
        stack.push(String.valueOf(root.val));
        if(root.right==null && root.left==null){//判断是否为叶子节点
            StringBuilder builder = new StringBuilder(stack.get(0));
            for(int i=1; i<stack.size(); i++){
                builder.append("->").append(stack.get(i));
            }
            res.add(builder.toString());
            stack.pop();
            return;
        }
        //不是叶子节点，继续遍历，左右子节点
        if(root.left!=null){
            //添加当前节点
            back(root.left, stack);
        }
        if(root.right!=null){
            back(root.right, stack);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);

        node1.left = node2;
        node2.right = node4;
        node1.right = node3;
        Solution solution = new Solution();
        List<String> strings = solution.binaryTreePaths(node1);
        strings.stream().forEach(System.out::println);
    }
}
