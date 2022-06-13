package Juc.jdk.threadlocal.gaofei.controller;

import Juc.jdk.threadlocal.gaofei.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springmvc是单例的:默认情况下,无论多少个请求到这个controller,此controller只会被实例化一次
 * 单例:线程安全问题
 */
@RestController
//@Scope("prototype")//多例模式
public class TestController {
    @Autowired
    MyUtil util;

    //成员变量i此时就存在安全问题
    //两个请求就代表两个线程,如果两个请求同时发过来,请求a  认为i的初始值是0,会返回1   请求b认为i的
    //初始值也是0 ,也会返回1,但是由于默认是单例,有一个请求返回了一个2,就导致数据不是我想要的结果

    @RequestMapping("a")
    public Object a() {
        util.set();
        int o = (int) util.get();
        return ++o;
    }

    @RequestMapping("b")
    public Object b() {
        util.set();
        int o = (int) util.get();
        return ++o;
    }
}
