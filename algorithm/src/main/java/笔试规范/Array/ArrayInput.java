package 笔试规范.Array;

import java.util.Scanner;

/**
 * 读取二维数组
 * author: luyi
 * time: 2022/3/9 15:16
 */
public class ArrayInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int[][] matrix = new int[r][c];
            sc.nextLine(); // 跳过行数和列数后的换行符

            for(int i=0;i<r;i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
        }
    }
}
