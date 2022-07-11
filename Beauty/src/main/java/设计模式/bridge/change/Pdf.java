package 设计模式.bridge.change;

/**
 * @Version: v1.0
 * @ClassName: Pdf
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public class Pdf extends File{
    public Pdf(Database database) {
        super(database);
    }

    @Override
    public void info() {
        super.info();
    }
}