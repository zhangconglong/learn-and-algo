package 设计模式.command.order;

/**
 * @version: v1.0
 * @className: Cooker
 * @description：厨师类
 * @author: zhangconglong on 2021/11/20
 */
public class Cooker {
    public void makeFood(String name, int num){
        for (int i = 0; i < num; i++) {
            System.out.println("制作了"+i+"份"+name);
        }
    }
}