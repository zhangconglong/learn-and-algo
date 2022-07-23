package 数据结构与算法.算法.贪心;//package 算法.贪心;
//
//import java.util.Arrays;
//
//class 自己的 {
//    int [] tempArr;
//
//    public boolean canJump(int[] nums) {
//        if(nums.length==1){
//            return true;
//        }
//        int len = nums.length;
//        int temp = 0, i,  i1;
//        int [] arr = new int[len];//每个节点能到达的最远节点
//
//
//        for (i = 0; i < nums.length-1; i++) {
//
//            temp = i + nums[i];//2
//            for (i1 = i+1; i1<=temp; i1++) {
//                tempArr = new int[temp];
//                arr[i] = Math.max(Arrays.sort(backTracing(tempArr)));
//            }
//        }
//        //遍历数组，发现有能到达最后的
//        return false;
//    }
//
//    public backTracing(int len){//更新数组
//
//        return max;
//    }
//}
