package com.mtcarpenter.tutorial.juc.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class CountDownLatchExample1 {

    private final static int gradeNum = 6;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newScheduledThreadPool(gradeNum);
        // 铃声信号
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < gradeNum; i++) {
            int gradeName = i + 1;
            exec.submit(() -> {
                try {
                    countDownLatch.await();
                    wait(gradeName);

                } catch (Exception e) {
                }
            });
        }
        // 3 秒之后开启 通知
        TimeUnit.SECONDS.sleep(3);
        System.out.println("通知、通知，请全体同学速来操场集合.....");
        countDownLatch.countDown();

        exec.shutdown();
    }

    private static void wait(int gradeName) throws Exception {
        TimeUnit.MILLISECONDS.sleep((int) Math.random() * 1000);
        System.out.println(gradeName + "年级所有同学到达操场");
    }
}

