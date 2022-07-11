package 设计模式.intermediary;

/**
 * 聊天用户
 */
public class ChatUser extends User{

    public ChatUser(String name) {
        super(name);
    }

    public ChatUser(String name, ChatGroup chatGroup) {
        super(name, chatGroup);
    }
}
