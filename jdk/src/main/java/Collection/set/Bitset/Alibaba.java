//package Collection.set.Bitset;
//
//import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.List;
//import java.util.Random;
//
///**
// * @see 题集.力扣.T56_合并区间.Solution#merge2
// */
//public class Alibaba {
//    public static void main(String[] args) {
//        Random random = new Random();
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < 1000_0000; i++) {
//            int randomResult = random.nextint(100000000);
//            list.add(randomResult);
//        }
//
//
//        BitSet bitSet = new BitSet(100000000);
//        for (int i = 0; i < 10000000; i++) {
//            bitSet.set(list.get(i));
//        }
//
//
//        System.out.println("0~1亿不在上述随机数中有" + bitSet.size());
//        for (int i = 0; i < 100000000; i++) {
//            if (!bitSet.get(i)) {
//                System.out.println(i);
//            }
//        }
//    }
//}