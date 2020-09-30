package com.mtcarpenter.tutorial.juc.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class SemaphoreExample1 {
    private final static int gradeNum = 6;

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newScheduledThreadPool(gradeNum);
        System.out.println("校门口红绿灯等待中.....");
        for (int i = 0; i < gradeNum; i++) {
            int gradeName = i + 1;
            exec.submit(() -> {
                try {
                    // 获取一个许可
                    semaphore.acquire();
                    wait(gradeName);
                    // 释放一个许可
                    semaphore.release();
                } catch (Exception e) {
                }
            });
        }
        exec.shutdown();
    }

    private static void wait(int gradeName) throws Exception {
        TimeUnit.SECONDS.sleep(1);
        System.out.println(gradeName + "年级通过红绿灯......");
    }
}
