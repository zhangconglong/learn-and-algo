package 数据结构与算法.算法.贪心;

public class Solution {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        //当前节点能达的最远 X
        //当前走过的节点，能到达的最远
        int rightmost = 0;//临时最远值

        for (int i=0; i<n; i++) {
            if (i<=rightmost) {//
                rightmost = Math.max(rightmost, i+nums[i]);

                if (rightmost >= n - 1) {//剪枝
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
