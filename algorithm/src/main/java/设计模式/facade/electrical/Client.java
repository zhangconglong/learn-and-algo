package 设计模式.facade.electrical;

public class Client {
    public static void main(String[] args) {
        TV tv = new TV();
        AirCondition airCondition = new AirCondition();
        Light light = new Light();
        SmartFacade smartFacade = new SmartFacade(light, tv, airCondition);
        smartFacade.on("电视");
    }
}
