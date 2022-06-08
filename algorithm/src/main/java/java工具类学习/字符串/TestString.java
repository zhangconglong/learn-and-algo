package java工具类学习.字符串;

import org.junit.Test;

/**
 * TestString
 * author: luyi
 * time: 2022/4/2 16:22
 */
public class TestString {

    @Test
    //判断是否含有某一个字符
    public void testString(){
        String str = "ghjk";
        System.out.println(str.contains("ggj"));
    }
}
