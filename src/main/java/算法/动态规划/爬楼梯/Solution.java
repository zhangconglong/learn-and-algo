//package 算法.动态规划.爬楼梯;
//
//class Solution {
//    //解法一、找规律，发现符合斐波那契
//    public int climbStairs(int n) {
//        int[] dp = int [n];//备忘录
//        return fib(n, dp);
//    }
//
//    public int fib(int n, int [] dp){
//        if(n==0){
//            return 1;
//        }
//        if(n==1){
//            return 2;
//        }
//
//        dp[n] = fib(n-1)+fib(n-2);
//
//        return dp[n];
//    }
//}
