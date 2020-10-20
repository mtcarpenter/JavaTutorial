package com.mtcarpenter.tutorial.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class ArrayBlockingQueueExample1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        try {
            queue.put("class 1");
            queue.put("class 2");
            queue.put("class 3");
            // 超过指定得容量当前线程阻塞
            queue.put("class 4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
