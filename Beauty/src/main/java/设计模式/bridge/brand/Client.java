package 设计模式.bridge.brand;

public class Client {
    public static void main(String[] args) {
        //联想台式机
        Computer computer = new Desktop(new Lenovo());
        computer.info();
        //苹果笔记本
        computer = new Laptop(new Apple());
        computer.info();
    }
}