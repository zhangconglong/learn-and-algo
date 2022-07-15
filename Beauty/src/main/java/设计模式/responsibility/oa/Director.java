package 设计模式.responsibility.oa;

public class Director extends AbstractApprover {
	public Director(String name) {
		super(name);
	}
//具体请求处理方法
	@Override
	public void processRequest(PurchaseRequest request) {
		if(request.getTime()<3) {
			System.out.println("主任"+this.name+"批准请假："+request.getTime());
			System.out.println("请假成功");
			
		}else {
			this.successor.processRequest(request);//转发请求
		}
		
	}

}