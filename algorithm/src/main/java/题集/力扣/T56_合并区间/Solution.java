package 题集.力扣.T56_合并区间;

import java.util.BitSet;

class Solution {
    public int[][] merge2(int[][] intervals) {
        BitSet bitSet = new BitSet();

        int max = 0;
        for (int[] interval : intervals) {
            // 比如[1,4]和[5,6]两个区间在数轴上是不连续的，但在BitSet上却是连续的。乘2是为了让它们从BitSet上看也是不连续的
            // bitSet.set() 函数 [x,y)
            int temp = interval[1] * 2 + 1;
            bitSet.set(interval[0] * 2, temp, true);
            max = temp >= max ? temp : max;
        }

        int index = 0, count = 0;
        while (index < max) {
            int start = bitSet.nextSetBit(index);
            int end   = bitSet.nextClearBit(start);

            int[] item = {start / 2, (end - 1) / 2};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        for (int i = 0; i < count; i++) {
            ret[i] = intervals[i];
        }

        return ret;
    }
}