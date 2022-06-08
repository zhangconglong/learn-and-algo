package 设计模式.singleton;

/**
 * 单例模式
 */
public class SingleUser {
    
    public static volatile SingleUser user = null;

    /**
     * 无参构造
     */
    public SingleUser() {
    }
    
    public static SingleUser getInstance(){
        if (user==null){
            synchronized (SingleUser.class){
                if (user==null){
                    synchronized (user){
                        user = new SingleUser();
                    }
                }
            }
        }
        
        return user;//已经实例化过了
    }
}
