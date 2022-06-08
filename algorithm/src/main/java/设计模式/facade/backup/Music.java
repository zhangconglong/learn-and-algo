package 设计模式.facade.backup;

/**
 * @Version: v1.0
 * @ClassName: Music
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public class Music extends PhoneFacade {
    public void backup(){
        System.out.println("音乐备份");
    }
}