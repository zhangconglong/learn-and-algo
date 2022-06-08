package 设计模式.bridge.brand;

//联想品牌
public class Lenovo implements Brand {

    @Override
    public void info() {
        System.out.print("联想");
    }
}