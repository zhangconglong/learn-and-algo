package 设计模式.responsibility.oa;

public abstract class AbstractApprover {
	protected AbstractApprover successor;//定义后继对象

	protected String name;//审批者姓名

	AbstractApprover(String name) {
		this.name=name;
	}
	
	//设置后继审批者
	public void setSuccessor(AbstractApprover successor) {
		this.successor=successor;
	}

	//抽象请求处理方法
	public abstract void processRequest(PurchaseRequest request);

}