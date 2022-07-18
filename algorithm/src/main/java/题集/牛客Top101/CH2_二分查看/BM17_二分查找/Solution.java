package 题集.牛客Top101.CH2_二分查看.BM17_二分查找;

/**
 * 升序数组的二分法查找
 *
 * @see https://www.nowcoder.com/practice/d3df40bd23594118b57554129cadf47b
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 4, 6, 10, 13, 14}, 13));
    }
}