package 蓝桥杯.第一天.统计及格率;

import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList();

        while(sc.hasNext()){
            list.add(sc.nextInt());
        }

//        list.sort();//从小到大进行排序

        //统计及格率  = 及格人数/总人数
        int jige = (int)list.stream()
              .filter(i -> i>=60)
              .count();
        System.out.println( Math.round(jige/list.size()) );//进行四舍五入
        //统计优秀率  = 及格人数/总人数
        jige = (int)list.stream()
                .filter(i -> i>=85)
                .count();
        System.out.println( Math.round(jige/list.size()) );//进行四舍五入
        sc.close();
    }
}
