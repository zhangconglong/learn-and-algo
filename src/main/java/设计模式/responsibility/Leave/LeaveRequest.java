package 设计模式.responsibility.Leave;

/**
 * @version: v1.0
 * @className: LeaveRequest
 * @description： 请假条类
 * @author: zhangconglong on 2021/11/20
 */
public class LeaveRequest {
    private String name;
    private int num;//请假的深度
    private String content;//请假的原因

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }
}