package Juc.threads;

/*
  推导lamda表达式
 */
public class Lamda {

    //3，静态内部类
    static class Like2 implements ILike{
        @Override
        public void lamda() {
            System.out.println("I like lamda2");
        }
    }

    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lamda();

        iLike = new Like2();
        iLike.lamda();
    }
}

interface ILike{ //定义一个函数式接口
    void lamda();
}

class Like implements ILike{//实现类

    @Override
    public void lamda() {
        System.out.println("I like lamda1");
    }
}