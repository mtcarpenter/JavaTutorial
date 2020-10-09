package com.mtcarpenter.tutorial.juc.looks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class LockExample1 {

    // 请求总数
    public static int requestTotal = 10000;

    // 并发计数
    public static int count = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        for (int i = 0; i < requestTotal; i++) {

            executorService.execute(() -> {
                try {
                    add();
                } catch (Exception e) {
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count = " + count);
    }

    private static synchronized void add() {
        count++;
    }
}
