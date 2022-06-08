package 设计模式.responsibility.Leave;

/**
 * @version: v1.0
 * @description： 小组长类
 * @author: zhangconglong on 2021/11/20
 */
public class GroupLeader extends Handler{

    public GroupLeader(){
        super(0, Handler.NUM_ONE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName()+"请假"+leave.getNum()+"天，"+leave.getContent()+"。");
        System.out.println("小组长审批：同意");
    }
}