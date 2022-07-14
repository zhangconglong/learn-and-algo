package 数据结构与算法.动态规划.牛客_动态规划专题.DP1_斐波那契;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/ee5d403c1172487f8c7915b3c3d924c6
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short n = in.nextShort();
    
        System.out.println(fibo(n));
    }
    
    public static int fibo(short n){
        int res = 0;
        if(n==1){
            res = 1;
        }else if(n==2){
            res = 1;
        }else { //大于2
            res = fibo((short) (n-1))+fibo((short) (n-2));
        }
        
        return res;
    }
}