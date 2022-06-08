package 设计模式.intermediary;

import java.util.ArrayList;

/**
 * 抽象聊天组
 */
public abstract class Group {
    protected ArrayList<User> group = new ArrayList<>();//群对象

    public void addUser(User user){ //用户加群
        user.chatGroup = (ChatGroup) this;
        this.group.add(user);
        System.out.println("System：有一个新用户加入群聊");
    }

    public abstract void say(String str);
}
