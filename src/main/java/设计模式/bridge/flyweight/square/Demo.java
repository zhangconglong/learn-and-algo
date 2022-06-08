package 设计模式.bridge.flyweight.square;

/**
 * @Version: v1.0
 * @ClassName: Demo
 * @Description：JDK中的应用
 * @Author: zhangconglong on 2021/11/11
 */
public class Demo {
    public static void main(String[] args) {
        //进行装箱
        //Integer i1 = Integer.valueof((int) 126);
        Integer i1 = 126;
        Integer i2 = 126;
        System.out.println("i1==i2："+ (i1==i2));

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println("i3==i4："+ (i3==i4));

        /**
         * 先执行： Integer i1 = Integer.valueof((int) 126);
         * 发现超出范围：Integer i1 = new Integer(126);
         * 因为Integer默认使用缓存-128~127之间的Integer对象
         * 不超出下标，直接从缓存中返回；否则创建一个新的Integer对象
         */
        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println("i5==i6: "+(i5==i6));
    }
}