package Juc.threadlocal.gaofei;

import java.util.HashMap;
import java.util.Map;

/**
 * 自己实现一个ThreadLocal
 * 
 * @author: luyi
 * time: 2022/6/13 9:08
 */
public class MyThreadLocal {

    Map<Thread, Object> map = new HashMap<>();

    public void set(Object obj){
        map.put(Thread.currentThread(), obj);
    }

    public Object get(){
        return map.get(Thread.currentThread());
    }
}
