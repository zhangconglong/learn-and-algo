package 设计模式.facade.backup;

/**
 * @Version: v1.0
 * @ClassName: Sms
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public class Sms extends PhoneFacade {
    public void backup(){
        System.out.println("短信备份");
    }
}