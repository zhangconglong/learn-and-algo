package 设计模式.command.order;

/**
 * @version: v1.0
 * @className: Client
 * @description：
 * @author: zhangconglong on 2021/11/20
 */
public class Client {
    public static void main(String[] args) {
        //创建第一个订单对象
        Order order  = new Order();
        order.setDiningTable(1);
        order.setFood("西红柿鸡蛋面",1);
        order.setFood("小分可乐",1);
        order.setFood("米饭",2);

        //创建第二个订单对象
        Order order2  = new Order();
        order.setDiningTable(1);
        order.setFood("土豆丝",1);
        order.setFood("雪碧",1);
        order.setFood("米饭",1);

        //创建厨师对象，接受对象
        Cooker cooker = new Cooker();
        //创建命令对象
        OrderCommand orderCommand = new OrderCommand(cooker, order);
        OrderCommand orderCommand2 = new OrderCommand(cooker, order2);

        //创建服务员
        Waitor waitor = new Waitor();
        waitor.orderUp();
    }
}