package 题目.力扣.LCS.LCS02完成一半的题目;

import java.util.Arrays;

class Solution {
    public int halfQuestions(int[] questions) {
        
        int[] hash = new int[1001];
        for(int num: questions){
            hash[num]++;
        }
        Arrays.sort(hash);
        int total = questions.length / 2;
        int res = 1;
        for(int i=hash.length-1;i>=0;i--){
            total -= hash[i]; // 剩余的
            if(total>0){
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}