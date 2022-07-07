package 面试题.网易.校招2021.第一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    //所有比第一个数小的放前面
    //所有比Max大的一定在最后面
    //内部进行递归
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=0;

        int n = sc.nextInt(), m = sc.nextInt();
        List<Integer> S = new ArrayList<>(n);
        List<Integer> T = new ArrayList<>(m);
        for (; i<T.size(); i++){
            T.add(sc.nextInt());
        }
        for (i = 0; i < S.size(); i++) {
            S.add(i);
        }


    }

}
