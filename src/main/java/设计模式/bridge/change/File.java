package 设计模式.bridge.change;

/**
 * @Version: v1.0
 * @ClassName: File
 * @Description：
 * @Author: zhangconglong on 2021/11/9
 */
public abstract class File implements Database {
    private Database database;

    public File(Database database) {
        this.database = database;
    }

    public void info(){
        database.info();
    }
}