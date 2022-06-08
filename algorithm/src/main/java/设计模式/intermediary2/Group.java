package 设计模式.intermediary2;

import java.util.ArrayList;

/**
 * 抽象聊天组
 */
public abstract class Group {
    protected ArrayList<User> group;

//    public Group(ArrayList<User> group) {
//        this.group = group;
//    }

    public void addUser(User user){ //用户加群
        group.add(user);
        System.out.println("System：有一个新用户加入群聊");
    }

    public abstract void say(String str);
}
