package 设计模式.responsibility.Leave;

/**
 * @version: v1.0
 * @description：抽象处理类
 * @author: zhangconglong on
 */
public abstract class Handler {
    protected final static int NUM_ONE  = 1;
    protected final static int NUM_THREE  = 3;
    protected final static int NUM_SEVEN  = 7;

    //该领导处理的请假区间
    private int numStart;
    private int numEnd;
    //上级领导
    private Handler nextHandler;

    public Handler(int level, int time) {
    }

    //设置上级领导
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //各级领导处理请假条的方法
    protected abstract void  handleLeave(LeaveRequest leave);

    //
    public final void submit(LeaveRequest leave){
        this.handleLeave(leave);
        //如果请假天数超出范围并且有上级
        if (this.nextHandler!=null && leave.getNum()>this.numEnd){
            //则提交到上级领导
            this.nextHandler.submit(leave);
        } else {
            System.out.println("流程结束！");
        }
    }

}