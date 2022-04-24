package 面试题.腾讯音乐.第三题;

public class Solution {
    public int minCnt (String s) {
        int length = s.length();
        int count = 0;//1的个数
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        //判断1和0的个数，只能留一个1，其余为0
        return count-1;
    }
}
