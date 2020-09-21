package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.CountDownLatch;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class AtomicExample2 {
    // 请求总数
    public static int requestTotal = 1000;
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        long start = System.currentTimeMillis();
        for (int i = 0; i < requestTotal; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("count=" + count);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    private static void add() {
        ++count;
    }
}