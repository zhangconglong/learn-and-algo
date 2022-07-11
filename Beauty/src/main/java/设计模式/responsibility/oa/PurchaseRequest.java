package 设计模式.responsibility.oa;

public class PurchaseRequest {
	private int time;   //请假时间
	public PurchaseRequest(int time) {
		this.time=time;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}