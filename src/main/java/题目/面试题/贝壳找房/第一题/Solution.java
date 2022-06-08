package 题目.面试题.贝壳找房.第一题;

import java.util.*;

public class Solution {
    public String NS_String (String s, int k) {
        //将字符串 转换成字符数组


        char[] ch = s.toCharArray();
        //进行排序
        Arrays.sort(ch);
        //去重
        HashSet<String> set = new HashSet<>(ch.length);
        int i=0;
        for (char c : ch) {
            if(!set.contains(ch[i])){
                set.add(String.valueOf(ch[i]));
            }
            i++;
        }
        Iterator it = set.iterator();
        //去除字符串中的字符
        for(i=0; i<k; i++){
            String s1 = it.next().toString();
            s = s.replace(s1, "");
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.NS_String("cbcb", 1));
    }
}
