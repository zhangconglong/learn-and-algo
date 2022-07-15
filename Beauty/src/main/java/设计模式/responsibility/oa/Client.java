package 设计模式.responsibility.oa;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        //职责中的关系对象
        AbstractApprover w1, w2, w3;
        w1 = new Director("");
        w2 = new VicePresident("");
        w3 = new President("");
        //创建职责链
        w1.setSuccessor(w2);
        w2.setSuccessor(w3);


        Scanner scan = new Scanner(System.in);
        System.out.println("请输入请假天数：");
        int time = scan.nextInt();

        PurchaseRequest pr1 = new PurchaseRequest(time);
        w1.processRequest(pr1);

    }
}