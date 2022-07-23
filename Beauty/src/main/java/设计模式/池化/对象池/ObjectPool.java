package 设计模式.池化.对象池;

import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

/**
 * 自定义对象池
 */
public class ObjectPool {
    /*使用链表实现对象池（实际推荐数组）*/
    private LinkedList<T> pool = new LinkedList();
    /*对象的构造函数*/
    private Constructor<T> constructor;
    /*定义一个空对象*/
    private final T template;
    /*对象池容量*/
    private int capacity;

    //构造函数
    public ObjectPool(Class<T> clazz, int capacity) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        constructor = clazz.getConstructor();
        template = constructor.newInstance();
        this.capacity = capacity;
        //初始化，放入100个对象
        for (int i = 0; i < this.capacity; i++) {
            pool.add(constructor.newInstance());
        }
    }

    //从对象池中取对象
    public T get() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if (pool.isEmpty()) {
            return constructor.newInstance();
        }
        return pool.pop();
    }

    /*
    回收对象到对象池（将对象重置）
    （1）引用类型，直接为 null
    （2）基本类型，赋值为 类型零值
     */
    public void recycle(T obj) {
        if (pool.size() < this.capacity) {
            BeanUtil.copyProperties(template, obj);
            pool.push(obj);
        }
    }
}