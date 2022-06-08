package 设计模式.responsibility.Leave;

/**
 * @version: v1.0
 * @description： 部门经理
 * @author: zhangconglong on 2021/11/20
 */
public class Manager extends Handler{

    public Manager(){
        super(2, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName()+"请假"+leave.getNum()+"天，"+leave.getContent()+"。");
        System.out.println("部门经理审批：同意");
    }
}