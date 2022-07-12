package 面试题.Y2022春招.腾讯音乐.模拟题;

import java.util.*;

/**
 * Solution
 * author: luyi
 * time: 2022/4/7 16:23
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int numCount = scanner.nextInt(), count;
        int i, j;
        ArrayList list;
        int res=-1, temp;

        for(i = 0; i<numCount; i++){
            count = scanner.nextInt();
            if(count==1){
                System.out.println(scanner.nextInt());
                continue;
            }

            list = new ArrayList();

            for(j=0; j<count; j++){
                temp = scanner.nextInt();
                if(!list.contains(temp)) {
                    list.add(temp);
                    res = Math.min(temp, res);
                }else {
                    list.remove(temp);
                }
            }
            if (list.size()==0)
                System.out.println(-1);;
            System.out.println(list.get(0));

        }
    }
}
