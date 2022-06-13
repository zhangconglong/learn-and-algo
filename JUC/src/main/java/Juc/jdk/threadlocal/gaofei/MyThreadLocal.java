package Juc.jdk.threadlocal.gaofei;

import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal {

    Map<Thread, Object> map = new HashMap<>();

    public void set(Object obj){
        map.put(Thread.currentThread(), obj);
    }

    public Object get(){
        return map.get(Thread.currentThread());
    }
}
