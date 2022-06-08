package 设计模式.bridge.change;

/**
 * @Version: v1.0
 * @ClassName: Mysql
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public class Mysql implements Database{
    @Override
    public void info() {
        System.out.println("MYSQL");
    }
}