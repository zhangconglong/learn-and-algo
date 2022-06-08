package 题目.面试题.互娱37;

/**
 * 股票最大收益
 * author: luyi
 * time: 2022/3/11 15:09
 */
public class 股票最大收益 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }

        int max=0;
        int min=prices[0];

        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }

        return max;
    }
}
