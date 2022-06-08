package 设计模式.bridge.flyweight.square;

/**
 * @Version: v1.0
 * @ClassName: AbstraxBox
 * @Description：抽象享元
 * @Author: zhangconglong on 2021/11/11
 */
public abstract class AbstractBox {

    //获取图形
    public abstract String getShape();

    //显示图形及颜色，抽象类中的默认方法
    public void display(String color){
        System.out.println("方块的形状"+getShape()+", 颜色"+color);
    }
}