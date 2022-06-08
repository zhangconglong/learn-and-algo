package 设计模式.bridge.change;

/**
 * @Version: v1.0
 * @ClassName: Txt
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public class Txt extends File{

    public Txt(Database database) {
        super(database);
    }

    @Override
    public void info() {
        super.info();
    }
}