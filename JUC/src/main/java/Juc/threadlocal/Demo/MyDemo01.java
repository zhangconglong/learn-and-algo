package Juc.threadlocal.Demo;

/**
 * 需求：线程隔离
 * 在多线程并发的场景下，每个线程中的变量都是相互独立
 * 线程A：设置（变量1）获取（变量1）
 * 线程B：设置（变量2）获取（变量2）
 * <p>
 * ThreadLocal：
 * 1.set()：将变量绑定到当前线程中
 * 2.get()：获取当前线程绑定的变量
 */
public class MyDemo01 {
    public ThreadLocal<String> threadLocal = new ThreadLocal<>();

    //变量
    private String content;

    public String getContent() {
        return threadLocal.get();
    }
    public void setContent(String content) {
        //this.content = content;
        threadLocal.set(content);//变量绑定到当前线程
    }
}
