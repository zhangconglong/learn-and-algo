package 面试题.Y2022春招.阿里;

import java.util.Scanner;

/**
 * 从最大体重开始，每次寻找体重最相近的人过河
 * 最后让最轻的一个或者两个人过河
 * author: luyi
 * time: 2022/3/23 14:37
 */
public class Test_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//行数

        for (int i = 0; i < n; i++) {//测试用例组数
            int [] arr = new int[sc.nextInt()];
            for (int j=0; j<arr.length; j++){
                arr[j] = sc.nextInt();
            }

        }

        //从最大体重开始，每次寻找体重最相近的人过河
        //将数组排序

    }
}
