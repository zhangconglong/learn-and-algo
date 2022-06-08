package 设计模式.bridge.change;

/**
 * @Version: v1.0
 * @ClassName: Oracle
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public class Oracle implements Database{
    @Override
    public void info() {
        System.out.println("Oracle");
    }
}