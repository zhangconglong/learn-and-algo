package 设计模式.command.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: v1.0
 * @className: Waitor
 * @description：服务员类，调用者角色
 * @author: zhangconglong on 2021/11/20
 */
public class Waitor {
    //持有多个命令对象
    private List<Command> commands = new ArrayList<>();

    public void setCommands(Command command) {
        //将command对象作为参数加入list集合中
        commands.add(command);
    }

    //发起命令
    public void orderUp(){
        System.out.println("大厨，订单来了");
        //遍历Iist集合
        for (Command command: commands){
            if (command!=null){
                command.execute();
            }
        }
    }
}