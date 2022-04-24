package 算法.动态规划.判断子字符串;

class Solution {
    //判断 s 是否为 t 的子序列。
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();

        int count = 0, temp = tLen-1;

        for(int i=sLen-1; i>=0; i--){
            for(int j=temp; j>=0; j--){
                temp--;
                if(s.charAt(i)==t.charAt(j)){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        return count == sLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("adb".charAt(2));
        System.out.println(solution.isSubsequence("bb", "ahbgdc"));
    }
}
