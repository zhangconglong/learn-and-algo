package 设计模式.facade.backup;

/**
 * @Version: v1.0
 * @ClassName: Client
 * @Description：测试类
 * @Author: zhangconglong on 2021/11/9
 */
public class Client extends PhoneFacade {
    public static void main(String[] args) {
        PhoneFacade phoneFacade = new PhoneFacade();
        phoneFacade.backup();
    }
}