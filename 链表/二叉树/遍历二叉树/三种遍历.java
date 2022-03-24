import java.util.*;

public class Solution {
    public int[][] threeOrders (TreeNode root) {
        int[][] array = new int[3][];//可以先指定一个维度
        
        //使用list原因，树的长度不固定
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        
        preOrder(root, list1);
        inOrder(root, list2);
        postOrder(root, list3);
        
        array[0] = new int[list1.size()];
        array[1] = new int[list2.size()];
        array[2] = new int[list3.size()];
        //将list转化成Array
        for (int i = 0; i < list1.size(); ++i){
            array[0][i] = list1.get(i);
            array[1][i] = list2.get(i);
            array[2][i] = list3.get(i);
        }
        return array;
    }
    
    //先序遍历：ULR
    public void preOrder (TreeNode root, ArrayList<Integer> list) {
        if(root!=null){
            list.add(root.val);//根节点
            preOrder(root.left, list);//左叶子节点
            preOrder(root.right, list);//右
        }
    }
    
    //中序遍历；LUR
    public void inOrder (TreeNode root, ArrayList<Integer> list) {
        if(root!=null){
            inOrder(root.left, list);//左叶子节点
            list.add(root.val);//根节点
            inOrder(root.right, list);//右
        }
    }
    
    //后续遍历：LRU
    public void postOrder (TreeNode root, ArrayList<Integer> list) {
         if(root!=null){
            postOrder(root.left, list);//左叶子节点
            postOrder(root.right, list);//右
            list.add(root.val);//根节点
        }
    }
}