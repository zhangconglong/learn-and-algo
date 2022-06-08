package 设计模式.facade.backup;

/**
 * @Version: v1.0
 * @ClassName: PhoneFacade
 * @Description：手机外观类，提供一键备份
 * @Author: zhangconglong on 2021/11/9
 */
public class PhoneFacade {
    Communication communication = new Communication();
    Sms sms = new Sms();
    Music music = new Music();
    Picture picture = new Picture();

    /**
     * 构造函数
     * @param communication
     * @param sms
     * @param music
     * @param picture
     */
//    public PhoneFacade(Communication communication, Sms sms, Music music, Picture picture) {
//        this.communication = communication;
//        this.sms = sms;
//        this.music = music;
//        this.picture = picture;
//    }

    /**
     * 一键备份
     */
    public void backup(){
        communication.backup();
        sms.backup();
        music.backup();
        picture.backup();
        System.out.println("一键备份完成");
    }
}