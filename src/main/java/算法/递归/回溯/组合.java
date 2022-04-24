package 算法.递归.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * author: luyi
 * time: 2022/3/23 18:58
 */
public class 组合 {
//    List<Stack> result = new ArrayList<Stack>();//存储结果
//    Stack stack = new Stack();//存放临时的序列
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>>  combine(int n, int k) {
        List stack = new ArrayList();
        backtrack(n, k, 1, stack);
        return result;
    }

    public void backtrack(int n,int k, int depth, List<Integer> stack) {
        if(stack.size() == k){
            result.add(new ArrayList<>(stack));//实现深拷贝
            return;
        }

        for(int i=depth; i<=n; i++){
            System.out.print("i = "+i);
            System.out.print(" depth:"+depth);
            System.out.println();
            stack.add(i);
            backtrack(n, k, i+1, stack);
            stack.remove(stack.size()-1);
        }
    }

    public static void main(String[] args) {
        组合 组合 = new 组合();
        List<List<Integer>> combine = 组合.combine(4, 3);
        combine.forEach(System.out::println);
    }
}
