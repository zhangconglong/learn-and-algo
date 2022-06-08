package 数据结构与算法.动态规划.couyingbi;

import java.lang.Math;

class Solution {
    //求最少的硬币个数 (每种硬币无限)
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int max = Integer.MAX_VALUE;

        int[] dp = new int[amount+1];//todo
        //初始化dp数组为最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for(int i=amount; i<coins.length ; i++){
            for(int j=coins[i]; j<coins.length; j++){
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[i - coins[j]], dp[j]) + 1;
                }
            }
        }

        return dp[amount] == max? -1 : dp[amount];
    }
}
