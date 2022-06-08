package Juc.me.集合.list;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ArrayListDemo线程不安全问题
 * author: luyi
 * time: 2022/3/11 23:12
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();

        for (int i = 0; i<30; i++){

            new Thread(()->{
               list1.add(UUID.randomUUID().toString().substring(0,8 ));
                System.out.println(list1);
            }).start();

        }

    }
}
