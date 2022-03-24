import java.util.*;

/*
 * 二叉树层次遍历
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        
        //队列用来存储每一层的数据
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);//头结点入队
        
        while(!queue.isEmpty()){//层次遍历
            ArrayList<Integer> list = new ArrayList<Integer>();//用来存放每一层的结果
            int size = queue.size();//提前进行赋值
            
            for(int i=0; i<size; i++){//原错误原因:i<queue.size()，queue是不断变化的!!
                root = queue.poll();//弹出一个节点
                if(root.left!=null)//左节点存在，加入下一层层
                    queue.offer(root.left);
                if(root.right!=null)
                    queue.offer(root.right);
                list.add(root.val);
            }

            result.add(list);
        }
        
        return result;
    }
}