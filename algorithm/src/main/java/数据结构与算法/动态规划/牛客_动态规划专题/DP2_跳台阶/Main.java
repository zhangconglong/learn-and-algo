package 数据结构与算法.动态规划.牛客_动态规划专题.DP2_跳台阶;

import java.util.Scanner;

/**
 *
 * @see https://www.nowcoder.com/practice/bfb2a2b3cdbd4bd6bba0d4dca69aa3f0
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println(fibo(in.nextInt()));
    }

    public static int fibo(int n) {
        int res = 0;
        if (n == 1) {
            res = 1;
        } else if (n == 2) {
            res = 2;
        } else { //大于2
            res = fibo(n - 1) + fibo(n - 2);
        }

        return res;
    }
}