package Juc.内存队列.伪内存共享;

class VolatileLong {
    /*
    使用volatile关键字来修饰，故CPU要保证它的修改对所有线程都立即可见,
    value的自增值会直接回写到内存，并将对应的缓存行置为失效.

    如果两个CPU核心对位于同一缓存行内的VolatileLong.value进行操作，那么它们会对这一行产生竞争，该【缓存就会频繁失效】
     */
    volatile long value;

    /*
    在64位系统中，一个缓存页大小为64B

    64B = 对象头mark word  8B
       + 对象头klass word  8B
       + value            8B
       + long*5           5*8B
     */
//    long padding1, padding2, padding3, padding4, padding5;
}

/**
 * 自定义线程
 */
class VolatileLongThread extends Thread {
    private VolatileLong[] shares;
    private int index;

    VolatileLongThread(VolatileLong[] shares, int index) {
        this.shares = shares;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            shares[index].value++;
        }
    }
}

public class FalseSharingDemo_2 {
    public static void main(String[] args) throws Exception {
        int processorsNum = Runtime.getRuntime().availableProcessors() / 2; // 超线程数/2 = 6
        System.out.println("Processor num: " + processorsNum);

        //共测试10次
        for (int i = 0; i < 10; i++) {
            //（1）数组存储（以缓存页大小加载数组）
            VolatileLong[] shareArray = new VolatileLong[processorsNum];

            //（2）创建12个线程
            for (int j = 0; j < processorsNum; j++) {
                shareArray[j] = new VolatileLong();
            }

            Thread[] threads = new Thread[processorsNum];
            for (int j = 0; j < processorsNum; j++) {
                threads[j] = new VolatileLongThread(shareArray, j);
            }

            //（3）启动线程，并让它们插队竞争
            for (Thread t : threads) {
                t.start();
            }

            long start = System.nanoTime();
            for (Thread t : threads) {
                t.join();
            }

            long end = System.nanoTime();
            System.out.println((i + 1) + " loop costs " + new Double(end - start) / Math.pow(10, 6) + " 毫秒");
        }
    }
}