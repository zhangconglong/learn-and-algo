package 设计模式.bridge.change;

/**
 * @Version: v1.0
 * @ClassName: Xml
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public class Xml extends File{
    public Xml(Database database) {
        super(database);
    }

    @Override
    public void info() {
        super.info();
    }
}