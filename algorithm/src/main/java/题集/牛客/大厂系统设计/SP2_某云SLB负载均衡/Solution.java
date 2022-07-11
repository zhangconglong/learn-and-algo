package 题集.牛客.大厂系统设计.SP2_某云SLB负载均衡;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 优先挑选最早加入的一台服务器
 */
public class Solution {

    static Deque<Integer> activeMachineS = new LinkedList<>();
    static ArrayList<Integer> log = new ArrayList<>();
    static HashSet<Integer> isUsing = new HashSet<>();

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param operators int整型ArrayList<ArrayList<>>
     * @return int整型ArrayList
     */
    public ArrayList<Integer> SLB(ArrayList<ArrayList<Integer>> operators) {

        operators.forEach( list ->{
            Integer i = list.get(0);
            switch (i){
                case 1: add(list.get(1));break;
                case 2: delete(list.get(1));break;
                case 3: select();break;
                case 4: release(list.get(1));break;
                default:break;
            }
        });

        return log;
    }

    public static void add(int i){
        if (activeMachineS.contains(i)) {
            activeMachineS.remove(i); //变为 新的添加的机器
        }
        activeMachineS.addLast(i); //队列实现
    }

    public static void delete(int i){
        activeMachineS.remove(i);

        if(isUsing.contains(i)){ //正在使用，但是突然下线，进行负载均衡
            isUsing.remove(i);
        }
    }

    public static void select(){
        if (activeMachineS.size()>0){
            Integer machineID = activeMachineS.pop();
            log.add(machineID);
            isUsing.add(machineID);
        }else {
            //没有可使用的服务器时，返回使用池中的服务器数量。
            log.add(isUsing.size());
        }
    }

    /**
     * 归还
     */
    public static void release(int i){
        activeMachineS.addLast(i);
        isUsing.remove(i);
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Integer[] arr1 = new Integer[]{1,3};
        Integer[] arr2 = new Integer[]{1,3};
        Integer[] arr3 = new Integer[]{1,4};
        Integer[] arr4 = new Integer[]{3};
        Integer[] arr6 = new Integer[]{2,4};
        Integer[] arr7 = new Integer[]{3};

        Integer[][] arr = new Integer[][]{
                arr1, arr2, arr3, arr4, arr6, arr7
        };

        for (Integer[] integers : arr) {
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer integer : integers) {
                list.add(integer);
            }
            res.add(list);
        }
        ArrayList<Integer> slb = new Solution().SLB(res);
        System.out.println(slb);
    }

    /**
     * 最早加入！
     * 10，4
     */

}