package 面试题.互娱37;

import java.util.*;

/**
 * 幂集
 *
 * 回溯：
 *       一个问题推导出多种可能，则选中其中一种可能继续推导。
 *      如果一条路到达尽头，则回到起点，选择另外的路径继续推导，直到所有可能被推导完毕。
 * author: luyi
 * time: 2022/3/11 15:29
 */
public class 幂集 {
    //构建一个空集[[]]
    Set<List<Integer>> set=new HashSet<>();

    //回溯
    public void backtrack(int[] nums,int first,List<Integer> pre){
        set.add(new ArrayList<>(pre));

        //
        for(int i=first;i<nums.length;i++){
            pre.add(nums[i]);
            backtrack(nums,i+1,pre);//递归调用
            pre.remove(pre.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);//从小到大

        List<List<Integer>> res=new ArrayList<>();//结果

        backtrack(nums, 0, new ArrayList<Integer>());
        res.addAll(set);

        return res;
    }

    public static void main(String[] args) {
        幂集 幂集 = new 幂集();
        int[] nums={1, 2, 3};
        List<List<Integer>> subsets = 幂集.subsets(nums);
        System.out.println(subsets);
    }
}
