//package 题目.蓝桥杯.第一天;
//
//import java.util.*;
//
//public class Main {
//    static class result{
//        public String key;
//        public int value;
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
//
//         if(str.length()==0){
//           System.out.println(str);
//           System.out.println(0);
//         }
//
//        String ch;
//
//
//        Map<String, Integer> map = new HashMap<>();//key为字母，value为出现的次数
//
//        for(int i=0; i<str.length(); i++){
//            ch = str.substring(i, i+1);
//
//            if(!map.containsKey(ch)){
//              map.put(ch, 1);//如果不存在直接放入
//            }else{
//              map.put(ch, map.get(ch)+1);//存在该字符，就++
//            }
//        }
//
//        int maxValue = 0;
//        //出现最多的字母和这个字母出现的次数。
////        map.forEach( (key, value)->{
////          if(value > maxValue){
////            maxValue = value;
////            ch = key;
////          }else if(value == maxValue){
////            //多个字母出现的次数相等，输出字典序最小的那个。
////            if(ch > key){
////              ch = key;
////              maxValue = value;
////            }
////          }
////        });
//        result res = new result();
//        for (int i = 0; i < map.size(); i++) {
//            if(map.get(result.key) > maxValue){
//                res.value = value;
//                ch = key;
//            }else if(value == maxValue){
//                //多个字母出现的次数相等，输出字典序最小的那个。
//                if(ch > key){
//                    ch = key;
//                    maxValue = value;
//                }
//            }
//        }
//
//        System.out.println(ch);
//        System.out.println(maxValue);
//        scan.close();
//    }
//}
