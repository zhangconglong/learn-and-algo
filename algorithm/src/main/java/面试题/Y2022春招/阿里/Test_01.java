package 面试题.Y2022春招.阿里;

import java.util.*;

/**
 * Test_01
 * author: luyi
 * time: 2022/3/23 14:00
 */
public class Test_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//行数
        int k = sc.nextInt();//列数
        int[][] array = new int[n][k];

        for (int i=0; i<n; i++) { //输入
            for(int j=0; j<k; j++){
                    array[i][j] = sc.nextInt();
            }
        }

        //求完美对的个数


    }
}
