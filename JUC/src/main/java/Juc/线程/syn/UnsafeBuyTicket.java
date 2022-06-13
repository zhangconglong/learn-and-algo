package Juc.线程.syn;

//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "苦逼的我").start();
        new Thread(buyTicket, "牛逼的你们").start();
        new Thread(buyTicket, "可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable{

    //票
    public int ticketNums = 10;
    boolean flag = true;//外部停止标志

    @Override
    public void run() {
        //买票
        while (flag){
            buy();
        }
    }

    private void buy(){
        //判断是否有票
        if(ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延迟
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}