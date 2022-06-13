package Juc.jdk.threadlocal.gaofei.util;

import Juc.jdk.threadlocal.gaofei.MyThreadLocal;
import org.springframework.stereotype.Component;


@Component//把这个类放入spring容器管理
public class MyUtil {

   int i = 0 ;

   //threadlocal 底层相当于是个map  ,key存的是一个线程,value就是咱们存的值
   private MyThreadLocal threadLocal = new MyThreadLocal();
    
   public void set(){
       threadLocal.set(i);
   }

    public  Object get (){
        return threadLocal.get();
    }
}
