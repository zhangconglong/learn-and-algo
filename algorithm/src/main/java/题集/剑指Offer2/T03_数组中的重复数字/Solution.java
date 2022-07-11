package 题集.剑指Offer2.T03_数组中的重复数字;

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * 解法一：Set
     *
     * 时间： O(N)
     * 空间：O(N)
     */
    public int findRepeatNumber(int[] nums) {
        Set<Short> dic = new HashSet<>();
        for(int num : nums) {
            if(dic.contains(num)) {
                return num;
            }
            dic.add((short) num);
        }
        return -1;
    }

    /**
     * 方法二：原地交换
     *
     * 把数组项 放到【同值的下标索引的桶】中
     * 比如[2, 3, 1, 0, 2, 5, 3]中，把2放到nums[2]中
     * 同一的索引下标出现重复项，就结束
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1) 节省空间
     */
//    public int findRepeatNumber(int[] nums) {
//        int i = 0;
//
//        while (i < nums.length) {
//            if (nums[i] == i) { //数字已在对应索引位置，无需交换
//                i++;
//                continue;
//            }
//
//            if (nums[nums[i]] == nums[i]) {
//                return nums[i];
//            }
//            int tmp = nums[i];
//            nums[i] = nums[tmp];
//            nums[tmp] = tmp;
//        }
//
//        return -1;
//    }

}