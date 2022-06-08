package 设计模式.command.order;

import java.util.Map;
import java.util.Set;

/**
 * @version: v1.0
 * @className: OrderCommand
 * @description：具体的命令类
 * @author: zhangconglong on 2021/11/20
 */
public class OrderCommand implements Command{
    //持有接受者对象
    private Cooker cooker;
    //
    private Order order;

    //构造方法
    public OrderCommand(Cooker cooker, Order order) {
        this.cooker = cooker;
        this.order = order;
    }

    @Override
    public  void execute(){
        System.out.println(order.getDiningTable()+"桌号：");
        Map<String, Integer> foodDir = order.getFood();
        //遍历map集合,将key转化成Set集合
        Set<String> keys = foodDir.keySet();
        for (String foodName : keys){
            cooker.makeFood(foodName, foodDir.get(foodName));
        }
        System.out.println(order.getDiningTable()+"桌的饭制作完毕");
    }
}