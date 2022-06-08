package 设计模式.intermediary;

/**
 * 抽象用户
 */
public abstract class User {
    protected ChatGroup chatGroup;
    String message = "";
    String name;

    public User(String name) {
        this.name = name;
    }

    public User(String name,ChatGroup chatGroup) {
        this.name = name;
        this.chatGroup = chatGroup;
    }

    public void userGroup(String str){//用户使用群发送消息
        System.out.print(name+": ");
        chatGroup.say(str);

    }
    public void getMessage(String str){//群让用户收到信息提醒
        this.message = str;
    }
}
