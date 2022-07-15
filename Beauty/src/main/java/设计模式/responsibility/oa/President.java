package 设计模式.responsibility.oa;

/**
 * 董事长 - 30天内的
 */
public class President extends AbstractApprover {

    public President(String name) {
        super(name);
    }

    //具体请求处理方法
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getTime() < 30) {
            System.out.println("总裁" + this.name + "批准请假：" + request.getTime());
            System.out.println("请假成功");
        } else {
            System.out.println("总裁：请假时间太长，不批准");
        }
    }
}