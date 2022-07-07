package 面试题.阿里.answer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");//读取第一行
        int n = Integer.parseInt(params[0]);//行数
        int k = Integer.parseInt(params[1]);//列数

        int[][] fields = new int[n][k];//原始数据
        HashMap<Integer, ArrayList<Integer>> counter = new HashMap<>();//

        int count = 0;//完美队的数量

        for(int i = 0; i < n; i++){
            //读取数组
            String[] row = br.readLine().trim().split(" ");
            for(int j = 0; j < k; j++) { //读取第一行
                fields[i][j] = Integer.parseInt(row[j]);
            }

            //同行相减：最后一列减第一列
            int diffSum = fields[i][k - 1] - fields[i][0];

            // 检查相反数是否在里面，并检查是否是完美对
            if(counter.containsKey(-diffSum)){
                for(int j = 0; j<counter.get(-diffSum).size(); j++) {
                    if(isValid(i, counter.get(-diffSum).get(j), fields)) {
                        count ++;
                    }
                }
            }

            if(counter.containsKey(diffSum)){//如果含有相反数，证明
                counter.get(diffSum).add(i);
            } else{
                ArrayList<Integer> path = new ArrayList<>();
                path.add(i);
                counter.put(diffSum, path);
            }
        }
        System.out.println(count);
    }


    private static boolean isValid(int i, int j, int[][] fields) {
        int sum = fields[i][0] + fields[j][0];//同行相加

        for(int fi = 1; fi < fields[0].length; fi++) {
            if(fields[i][fi] + fields[j][fi] != sum) {////验证是否为完美对
                return false;
            }
        }
        return true;
    }
}
