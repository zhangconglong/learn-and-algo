package 设计模式.responsibility.oa;


/**
 * leader -只能批三天内的
 *
 * @author: luyi
 * time: 2022/7/15 13:15
 */
public class Director extends AbstractApprover {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getTime() < 3) {
            System.out.println("leader" + this.name + "批准请假：" + request.getTime());
            System.out.println("请假成功");

        } else {
            this.successor.processRequest(request);//转发请求
        }
    }
}