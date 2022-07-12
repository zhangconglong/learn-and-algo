package 修饰符.final_;

/**
 * @author zhangconglong
 * @version [1.0.0, 2022/7/12]
 */
public class Final赋值时机 {
    //一、声明时赋值
    private final int val_1 = 10;


    private final int val_2;
    /**
     * 构造函数
     */
    Final赋值时机(){
        val_2 = 2;
    }

    private final int val_3;

    {
        val_3 = 10;
        System.out.println("hello");
    }
}
