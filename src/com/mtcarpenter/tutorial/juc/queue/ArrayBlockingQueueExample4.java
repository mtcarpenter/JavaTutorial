package com.mtcarpenter.tutorial.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class ArrayBlockingQueueExample4 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        // 队列无元素 直接返回 null
        System.out.println(queue.poll( ));
        System.out.println(queue.peek( ));
    }
}
