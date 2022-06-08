package 设计模式.bridge.flyweight.square;

import java.util.HashMap;

/**
 * @Version: v1.0
 * @ClassName: BoxFactory
 * @Description：享元工厂类，将该例设计为单例
 * @Author: zhangconglong on 2021/11/11
 */
public class BoxFactory {

    private HashMap<String, AbstractBox> map;
    private static BoxFactory factory = new BoxFactory();

    //在构造方法中进行初始化操作
    private BoxFactory(){
        map = new HashMap<String, AbstractBox>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    //提供方法获取工厂 -- 饿汉式
    public static BoxFactory getInstance(){
        return factory;
    }

    //根据名称获取图形对象
    public AbstractBox getShape(String name){
        return map.get(name);
    }

}