package 数据结构与算法.队列.数组中的第K个最大元素215;

import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        short temp = 1;
//        int back = nums[nums.length-1];
        int back = nums[nums.length-k];

//        for (short i = (short)(nums.length-2); i>=0; i--) {
//            if(nums[i]!=back){//遇到相同，不加
//                back = nums[i];
//                temp++;
//            }
//            if (temp==k) {
//                break;
//            }
//        }

        return back;
    }
}
