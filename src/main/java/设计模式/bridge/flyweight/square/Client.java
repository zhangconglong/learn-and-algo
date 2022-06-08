package 设计模式.bridge.flyweight.square;

/**
 * @Version: v1.0
 * @ClassName: Client
 * @Description：测试类
 * @Author: zhangconglong on 2021/11/11
 */
public class Client {

    public static void main(String[] args) {

        /**
         * 享元工厂中的HashMap（享元池）始终只有3个对象
         * 每次使用getShape从里面拿，不需要每次创建
         */
        //获取I图形对象
        AbstractBox box1 = BoxFactory.getInstance().getShape("I");
        box1.display("灰色");

        //获取I图形对象
        AbstractBox box2 = BoxFactory.getInstance().getShape("L");
        box2.display("黄色");

        //获取O图形对象
        AbstractBox box3 = BoxFactory.getInstance().getShape("O");
        box3.display("绿色");

        //获取O图形对象
        AbstractBox box4 = BoxFactory.getInstance().getShape("O");
        box4.display("蓝色");

        /**
         * 获取到的竟然是同一个对象！！
         */
        System.out.println("获取的是否是同一个对象："+ (box1==box3));
    }
}