package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class AtomicExample11 {
    // 并发线程数
    public static int requestTotal = 500;
    // 求和总数
    public static int sumTotal = 1000000;
    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(requestTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        long start = System.currentTimeMillis();
        for (int i = 0; i < requestTotal; i++) {
            executorService.execute(() -> {
                add();
                countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count=" + count);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    private static void add() {
        // 针对 sumTotal 求和
        for (int j = 0; j < sumTotal; j++) {
            count.add(1);
        }
    }
}
