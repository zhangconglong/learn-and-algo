package 数据结构与算法.动态规划.最短路径;//package 算法.动态规划.最短路径;
//
//import java.util.Arrays;
//
//class Solution {
//    /*
//    问题：最短路径
//    子问题：走到左或上的最小路径
//    dp[i][j]含义：走到i,j的最短路径
//    dp[i][j] = Math.min(dp[i][j-1]+grid[i][j],//向右
//                        dp[i-1][j]+grid[i][j]//向下
//                    );
//    */
//    public int minPathSum(int[][] grid) {
//        if(grid.length==1&&grid[0].length==1) return grid[0][0];
//
//        int sum = Arrays.stream(grid[0]).sum();
//        //行数：grid.length
//        //列数：grid[0].length
//        int [][] dp = new int[grid.length+1][grid[0].length+1];
//
//        if(grid.length==1){//只有一列
//
//            return Arrays.stream(grid[0]).sum();
//        }
//        if(grid[0].length==1){//只有一行
//            return Arrays.stream(grid[][0]).sum();
//        }
//
//       //初始化dp数组
//       int i=0, j=0;
//       dp[1][1] = grid[0][0];//第一个格子
//
//        for(i=2; i<dp[0].length; i++){//初始化第一行
//            dp[1][i] = dp[1][i-1] + grid[0][i-1];//向右
//        }
//        for(j=2; j<dp.length; j++){//初始化第一列
//            dp[j][1] = dp[j-1][1] + grid[j-1][0];//向右
//        }
//
//       //遍历
//       for(i=2; i<dp.length; i++){
//            for(j=2; j<dp[0].length; j++){
//                System.out.println("===");
//                dp[i][j] = Math.min(
//                        dp[i][j-1]+grid[i-1][j-1],//向右
//                        dp[i-1][j]+grid[i-1][j-1]//向下
//                    );
//            }
//        }
//
//        for(i=0; i<dp.length; i++){
//            for(j=0; j<dp[0].length; j++){
//                //如果还有位置
//                System.out.print(dp[i][j]+"  ");
//            }
//            System.out.println();
//        }
//
//        return dp[i-1][j-1];
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int [][] arr = {
//                {1,2,3},
////                {1,3,1},
//                {4,5,6}
//        };
//        System.out.println(solution.minPathSum(arr));
//    }
//}
