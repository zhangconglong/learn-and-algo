package 数据结构与算法.算法.查找.二分查找;

public class BinarySearch_Demo_01 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        System.out.println(binarySearch(arr, 15));
    }

    /**
     * 二分查找
     *
     * @param arr  数组
     * @param data 要寻找的数
     * @return index 下标
     */
    public static int binarySearch(int[] arr, int data) {
        int low = 0;
        int height = arr.length - 1;

        while (low <= height) {
            int mid = low + (height - low) / 2;

            if (arr[mid] < data) {
                low = mid + 1;
            } else if (arr[mid] == data) {
                return mid;
            } else {
                height = mid - 1;
            }
        }
        return -1;
    }
}
