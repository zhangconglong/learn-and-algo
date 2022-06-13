package Juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {


        List<String> list1 = new Vector<>();
        //工具类
        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        //并发包
        List<String> list = new CopyOnWriteArrayList<>();


        /*
        CopyOnWrite写入时复制,
        在写入时避免覆盖,造成数据问题
        读写分离,在写入时
         */
        for (int i=0; i<10; i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}