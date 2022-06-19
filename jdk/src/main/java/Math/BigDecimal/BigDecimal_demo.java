package Math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author: luyi
 * time: 2022/6/19 22:47
 */
@Slf4j
public class BigDecimal_demo {

    public static void main(String[] args) {
        compare();
        calculate();
    }

    public static void compare() {
//        BigDecimal bigDecimal = BigDecimal.ONE;
        BigDecimal bigDecimal = new BigDecimal("1.0");
        BigDecimal bigDecimal1 = new BigDecimal("1.00");
        
        System.out.println( "==: " + (bigDecimal==bigDecimal1)  );//比较地址。new创建，地址不同
        System.out.println( "equals: " + bigDecimal.equals(bigDecimal1)  ); //重写了equals，比较scale
        //推荐
        System.out.println( "compareTo: " + (bigDecimal.compareTo(bigDecimal1)==0) );//忽略位数


        /* 比较2.0和2.00
         *  （1）equals 不等
         *      【无法用于金额比较】（类似String）
         *          要求 位数 也必须要相同
         *  （2）compareTo 相等
         *      >0 第一个大于第二个
         *      <0 第一个小于第二个    
         */
    }

    /**
     * new创建
     *   （1）使用字符串（强制）
     *   （2）使用整数
     */
    public static void calculate() {
        BigDecimal bigDecimal = new BigDecimal(1.2);
//        BigDecimal bigDecimal = new BigDecimal("1.2");
        BigDecimal bigDecimal1 = new BigDecimal("1.2234");
        
        //精度丢失
        System.out.println( "\n\n" + "compareTo: " + (bigDecimal.add(bigDecimal1)) );//忽略位数
        
    }
}
