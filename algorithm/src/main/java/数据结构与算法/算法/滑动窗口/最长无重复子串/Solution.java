package 数据结构与算法.算法.滑动窗口.最长无重复子串;//package 算法.滑动窗口.最长无重复子串;
//
//import java.util.HashSet;
//import java.util.Hashtable;
//import java.util.Set;
//
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        int len = s.length();
//        if (s.length()<=1) return len;
//
//        String [] strList = s.split("");
//        Hashtable<String, v> table = new Hashtable<>();
//
//        Set<String> set = new HashSet<>();
//        set.add(strList[0]);
//
//        int start=0, max=1;
//
//        for(int i=1; i<len; i++){
//            if(set.contains(strList[i])) {
//                //进行窗口滑动
//
//                continue;
//            }
//            set.add(strList[i]);
//            max=Math.max(set.size(), max);
//        }
//        return max;
//    }
//}
