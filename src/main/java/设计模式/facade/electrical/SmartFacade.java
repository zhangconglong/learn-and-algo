package 设计模式.facade.electrical;

/**
 * 外观模式类
 */
public class SmartFacade {
    Light light;
    TV tv;
    AirCondition airCondition;


    public SmartFacade(Light light, TV tv, AirCondition airCondition) {
        this.light = light;
        this.tv = tv;
        this.airCondition = airCondition;
    }

    public void on(String voice){
        if (voice.contains("打开")){
            if (voice.contains("电灯")){
                light.on();
            }else if (voice.contains("电视")){
                tv.on();
            }else if (voice.contains("空调")){
                airCondition.on();
            }
        }

    }

    public void off(String voice){

        light.off();
        tv.off();
        airCondition.off();
    }
}