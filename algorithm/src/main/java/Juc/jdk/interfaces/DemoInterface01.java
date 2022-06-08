package Juc.jdk.interfaces;

public class DemoInterface01 {

    public static void main(String[] args) {
        A b = new B();
        b.test2();
    }
}

interface A{
    void test1(); //抽象方法

    default String test2() { //默认方法
        System.out.println("接口中的默认方法...");
        return "hello";
    }

    static String test3() { //静态方法
        System.out.println("接口中的静态方法...");
        return "hello";
    }
}

class B implements A{

    @Override
    public void test1() {

    }

    @Override
    public String test2() {
        System.out.println("重写了默认方法");
        return "world";
    }
}