package 题目.面试题.百度;//package 题目.面试题.百度;
//
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.Scanner;
//
///**
// * 题目.面试题.baidu.Test_1
// * author: luyi
// * time: 2022/3/22 19:36
// */
//public class Test_1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();//行数
//        int k = sc.nextInt();//放大的倍数
//
////         int [][] array = new int[n][n];//输入数据
//        int temp = 0;
//         int [][] result = new int[n*k][n*k];//存放结果
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                temp = sc.nextInt();
//                //进行复制
//                for(int x=k*i; x<=(k)*(i+1)-1; x++){
//                    for(int y=k*j; y<=(k)*(j+1)-1; y++){
//                        result[x][y] =temp;
////                        System.out.print(temp+" ");
//                    }
////                    System.out.println();
//                }
//            }
//        }
//        LocalDateTime t = LocalDateTime.ofEpochSecond(time/1000, 0, ZoneOffset.UTC);
//
//        for(int i=0; i<k*n; i++){
//            for(int j=0; j<k*n; j++){
//                        System.out.print(result[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//}
