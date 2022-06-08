package 设计模式.bridge.brand;

public class Apple implements Brand {
    @Override
    public void info() {
        System.out.print("苹果");
    }
}