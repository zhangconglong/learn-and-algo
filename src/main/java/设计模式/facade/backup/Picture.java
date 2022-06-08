package 设计模式.facade.backup;

/**
 * @Version: v1.0
 * @ClassName: Picture
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public class Picture extends PhoneFacade {
    public void backup(){
        System.out.println("照片备份");
    }
}