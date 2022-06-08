package Juc.threads.syn;

//不安全的取钱
public class UnsafeBank {
}

//账户
class Account{
    int money;
}

//银行：模拟取款
class Drawing extends Thread{
    Account account;
    //取了多少钱
    int drawingMoney;
    //现在有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, int nowMoney){

        this.account = account;
        this.drawingMoney = drawingMoney;
        this.nowMoney = nowMoney;
    }

    @Override
    public void run() {

        //判断有没有钱
        if (account.money<0){
            nowMoney  += drawingMoney;
        }

    }
}