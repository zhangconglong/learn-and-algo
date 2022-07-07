package 面试题.阿里.answer.t2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 选礼品
 * @Author: luyi
 * @Time: 2022/3/23 15:17
 */
public class Main {
    /*存储结果：选择栈是为了保证输出顺序*/
    public static ArrayList<Stack<Integer>> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");

        int n = Integer.parseInt(params[0]);//行：总数
        int m = Integer.parseInt(params[1]);//列：礼物个数

        dfs(n, m, 1, new Stack<Integer>());//栈: 先进先出

        //输出结果
        for(Stack<Integer> stack: res){
            for(Integer elem : stack) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }


    private static void dfs(int n, int m, int depth, Stack<Integer> stack) {
        if(stack.size() == m){ //选够m个礼物，遍历结束
            res.add((Stack<Integer>) stack.clone());//将当前栈放入结果集
            return;
        }

        for(int i = depth; i<=n; i++){
            stack.push(i);
            dfs(n, m, i + 1, stack);
            stack.pop();
        }
    }
}
