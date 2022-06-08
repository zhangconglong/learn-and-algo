package 数据结构与算法.递归.回溯.全排列;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> listRes = new ArrayList<>();
        boolean[] bol = new boolean[len];//剩下那些元素未被使用(默认为false)
        Deque<Integer> stack = new ArrayDeque<>();

        back(nums, len, 0, bol, stack, listRes);
        return listRes;
    }

    public void back(int[] nums, int len, int temp,
                     boolean[] bol,
                     Deque<Integer> stack,
                     List<List<Integer>> listRes){

        if(temp==len){//终止条件
            listRes.add(new ArrayList<>(stack));
            return;
        }

        for(int i=0; i<len; i++){
            if (bol[i]){
                continue;
            }
            stack.addLast(nums[i]);
            bol[temp] = true;
            back(nums, len, temp+1, bol, stack, listRes);
            //取消选择
            stack.removeLast();
            bol[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(test);
        permute.stream().forEach(System.out::println);
    }
}
