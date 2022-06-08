package 设计模式.intermediary;

/**
 * 测试类
 */
public class Client {

   public static void main(String[] args) {
        //创建聊天群组
       ChatGroup groupA= new ChatGroup();

       //创建聊天用户
       ChatUser userA = new ChatUser("userA", groupA);
       ChatUser userB = new ChatUser("userB",groupA);
       ChatUser userC = new ChatUser("userC",groupA);
       ChatUser userD = new ChatUser("userD",groupA);
       ChatUser userE = new ChatUser("userE");

       userA.userGroup("我喜欢篮球，大家的爱好是什么？");
       userB.userGroup("我喜欢足球");
       userC.userGroup("我喜欢乒乓球");
       userD.userGroup("我喜欢台球");

       userB.userGroup("我的足球技术一般，大家的水平怎么样？");
       userA.userGroup("我的篮球水平也一般");
       userC.userGroup("我的乒乓球技术还行");
       userD.userGroup("我的台球也很菜啦");

       groupA.addUser(userE);//E加入群聊
       userE.userGroup("大家好，我是E");

    }
}
