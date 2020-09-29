package com.mtcarpenter.tutorial.juc.tools;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class CyclicBarrierExample2 {

    private final static int gradeNum = 6;

    private static CyclicBarrier barrier = new CyclicBarrier(3);

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newScheduledThreadPool(gradeNum);
        System.out.println("通知、通知，请准备的年级先出发.....");
        for (int i = 0; i < gradeNum; i++) {
            TimeUnit.SECONDS.sleep(1);
            int gradeName = i + 1;
            exec.submit(() -> {
                try {
                    wait(gradeName);
                } catch (Exception e) {
                }
            });
        }
        exec.shutdown();
    }

    private static void wait(int gradeName) throws Exception {
        TimeUnit.SECONDS.sleep(1);
        System.out.println(gradeName + "年级所有同学来到了出口......");
        try {
            barrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("CyclicBarrier 超时异常:  " + gradeName + "年级-" + e);
        }
        System.out.println(gradeName + "年级所有同学到出发");
    }
}