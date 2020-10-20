package com.mtcarpenter.tutorial.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class ArrayBlockingQueueExample2 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.add("class 1");
        queue.add("class 2");
        queue.add("class 3");
        // 超过指定容量 抛出异常
        queue.add("class 4");
    }
}
