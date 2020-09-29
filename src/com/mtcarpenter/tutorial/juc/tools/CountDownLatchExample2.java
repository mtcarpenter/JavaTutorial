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
public class CountDownLatchExample2 {
    private final static int gradeNum = 6;
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newScheduledThreadPool(gradeNum);
        final CountDownLatch countDownLatch = new CountDownLatch(gradeNum);
        for (int i = 0; i < gradeNum; i++) {
            int gradeName = i + 1;
            exec.submit(() -> {
                try {
                    wait(gradeName);
                } catch (Exception e) {
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        System.out.println("等待所有年级集合准备.....");
        countDownLatch.await();
        System.out.println("所有年级准备好了，出发.........");
        exec.shutdown();
    }
    private static void wait(int gradeName) throws Exception {
        TimeUnit.MILLISECONDS.sleep((int) Math.random() * 1000);
        System.out.println(gradeName + "年级已经准备好了");
    }
}
