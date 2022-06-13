package Juc.新特性.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest02 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三", "张三丰","成龙");
        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length()==3)
                .forEach(System.out::println);
    }
}