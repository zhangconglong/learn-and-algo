package Juc.me.集合.list;

import java.util.List;
import java.util.UUID;
import java.util.Vector;

/**
 * 通过synchronized关键字实现
 * author: luyi
 * time: 2022/3/11 23:25
 */
public class VectorDemo {
    public static void main(String[] args) {
        List<String> list1 = new Vector<>();

        for (int i = 0; i<30; i++){
            new Thread(()->{
                list1.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list1);
            }).start();
        }

    }
}
