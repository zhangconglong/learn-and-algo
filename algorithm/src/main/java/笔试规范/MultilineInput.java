package 笔试规范;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 多行输入
 * author: luyi
 * time: 2022/3/9 15:17
 */
public class MultilineInput {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);//Scanner类默认的分隔符就是空格

        //循环读取
        while(sc.hasNext()){
            int n=sc.nextInt();int full=sc.nextInt();int avg=sc.nextInt();//第一行的输入

            int[][] nums=new int[n][2];

            /**
             * 0 5
             * 9 1
             * 8 1
             * 0 1
             * 9 100
             */
            for(int i=0;i<n;i++){
                nums[i][0]=sc.nextInt();
                nums[i][1]=sc.nextInt();
            }
            //假定不会出现拿不到奖学金的情况
            if (n==1){
                System.out.println((avg-nums[0][0])*nums[0][1]);
                continue;
            }

            Arrays.sort(nums, (o1, o2) -> o1[1] - o2[1]);//按复习代价从小到大排序
            long sum=0;//已经复习到达的总和
            for(int[] a:nums) {
                sum+=a[0];
            }
            //
            long limit=avg*n; //拿到奖学金要达到的总金额
            int index=0;
            long time=0;

            while(sum<limit){
                //tmp这门课还差多少分
                int tmp=full-nums[index][0];

                //如果一门课程复习到满分，小于限制
                if(tmp+sum<=limit){                
                    time+=tmp*nums[index][1];//复习这门课，并加上这么课的时间
                    sum+=tmp;//统计已复习课的总时间
                    index++;
                }
                //如果一门课程复习到满分，大于限制
                else{
                    time+=(limit-sum)*nums[index][1];
                    sum=limit;
                }
            }

            System.out.println(time);
        }
    }
}
