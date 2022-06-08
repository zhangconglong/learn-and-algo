package 设计模式.responsibility.oa;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		//职责中的关系对象
		Approver w1,w2,w3;
		w1=new Director("小红1");
		w2=new VicePresident("小红2");
		w3=new President("小红3");
		//创建职责链
		w1.setSuccessor(w2);
		w2.setSuccessor(w3);
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("请输入请假天数：");
			int time=scan.nextInt();		
			PurchaseRequest pr1=new PurchaseRequest(time);
			w1.processRequest(pr1);
		}	
	}
}