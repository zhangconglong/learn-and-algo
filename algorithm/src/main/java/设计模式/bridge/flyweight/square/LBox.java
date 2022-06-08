package 设计模式.bridge.flyweight.square;

/**
 * @Version: v1.0
 * @ClassName: IBox
 * @Description：L形类（具体享元角色）
 * @Author: zhangconglong on 2021/11/11
 */
public class LBox extends AbstractBox{

    @Override
    public String getShape() {
        return "L";
    }
}