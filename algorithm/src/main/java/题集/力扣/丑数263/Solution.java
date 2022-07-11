package 题集.力扣.丑数263;

class Solution {
    public boolean isUgly(int num) {
        if (num<1) {
            return false;
        }
        
        /*
        不断除2,3,5，最后剩1就是，剩0就不是
        (除2可以用位运算替换)
         */
        while (num%5==0){
            num/=5;
        }
        while (num%3==0){
            num/=3;
        }
        while (num%2==0){
            num>>=1;
        }
        return num == 1;
    }
}