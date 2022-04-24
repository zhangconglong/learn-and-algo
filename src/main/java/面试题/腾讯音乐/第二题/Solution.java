package 面试题.腾讯音乐.第二题;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int minMax (ArrayList<Integer> a, int k, int x) {
        int len = a.size();

        if(a.size()==1)
            return a.get(0)-k*x;

        int[] arr = new int [len];
        for (int i = 0; i < len; i++) {
            arr[i] = a.get(i);
        }

        int res = 0, temp;
        for (int i = 0; i < k; i++) {
            arr[len-1] -= x;
            if(arr[len-1]<arr[len-2]){//发生乱序
                Arrays.sort(arr);//从小到大
            }
            res = arr[len-1];
            System.out.println(res);
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list =  new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(1);
        System.out.println("res:"+new Solution().minMax(list, 3, 2));
    }
}

//                for (int j=len-2; j>=0; j--) {//排序
//                    if(arr[len-1]<=arr[j]){
//                        temp=arr[j];
//                        arr[j]=temp;
//                        arr[len-1]=temp;
//                    }
//                }
