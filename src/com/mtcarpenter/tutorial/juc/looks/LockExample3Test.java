package com.mtcarpenter.tutorial.juc.looks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class LockExample3Test {

    // 请求总数
    public static int requestTotal = 10;


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        for (int i = 0; i < requestTotal; i++) {
            final String temp = String.valueOf(i);
            executorService.execute(() -> {
                try {
                    add(temp);
                } catch (Exception e) {
                }
                countDownLatch.countDown();
            });
        }
        // 等待所有的线程运行完成
        countDownLatch.await();
        // 多线程获取 key
        for (int i = 0; i < requestTotal; i++) {
            final String temp = String.valueOf(i);
            executorService.execute(() -> {
                try {
                    get(temp);
                } catch (Exception e) {
                }
            });

        }
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(1);
        // 获取所有的keys
        System.out.println("获取所有的键值\t" + LockExample3.getAllKeys());
        //  清除所有的 keys
        LockExample3.clear();
        // 再次获取所有的keys 发现已被清空
        System.out.println("获取所有的键值\t" + LockExample3.getAllKeys());

    }

    private static void add(String i) {
        LockExample3.put(i, Thread.currentThread().getName());
    }

    private static void get(String i) {
        System.out.println(i + "\t" + LockExample3.get(i));
    }
}