package 设计模式.intermediary;

/**
 * 具体聊天组
 */
public class ChatGroup extends Group {

    public void say(String str){
        System.out.println(str);//群内发消息
        int i = 0;
        while (i<group.size()){//给用户发送最新消息通知
            ((User) (group.get(i))).getMessage(str);
        }
    }
}
