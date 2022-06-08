package 设计模式.facade.backup;

/**
 * @Version: v1.0
 * @ClassName: communication
 * @Description：通讯录类
 * @Author: zhangconglong on 2021/11/9
 */
public class Communication extends PhoneFacade {
    public void backup(){
        System.out.println("通讯录备份");
    }
}