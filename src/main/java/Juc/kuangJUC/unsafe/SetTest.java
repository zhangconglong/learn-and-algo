package Juc.kuangJUC.unsafe;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest{

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = Collections.synchronizedSet(new HashSet<>());
        Set<String> set3 = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                set1.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set1);
            }, String.valueOf(i)).start();
        }
    }
}