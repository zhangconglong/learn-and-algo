package 数据结构与算法.动态规划.背包问题;

import java.util.Scanner;

/**
 * 背包01
 * author: luyi
 * time: 2022/3/27 15:51
 */
public class 背包01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        int [] wight = new int[N];
        int [] value = new int[N];

        for (int i = 0; i<N; i++){
            wight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        //创建DP数组
        int[][] dp = new int[N+1][V+1];
        //初始化DP数组
        //本题的（可以不用初始化化）
        // dp[0][] = 0
        // dp[][0] = 0

        for(int i=1; i<=N; i++){
            for(int w=1; w<=V; w++){

                if(w < wight[i]){
                    dp[i][w] = dp[i-1][w];//放不下
                }
                else { //背包中能放下该物体
                    //择优
                    dp[i][w] = Math.max(
                            dp[i-1][w-wight[i-1]] + value[i-1] //放入该礼品
                            , dp[i-1][w] //不放
                    );
                }
            }
        }

        System.out.println(dp[N][V]);
        sc.close();
    }
}
