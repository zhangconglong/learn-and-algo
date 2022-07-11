package 设计模式.strategy;

public class Client {

    public static void main(String[] args) {
        PayContext payContext = new PayContext();

        System.out.println(
                payContext.selectPayWay(100)
        );
    }
}