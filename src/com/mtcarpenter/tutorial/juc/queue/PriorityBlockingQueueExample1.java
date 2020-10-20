package com.mtcarpenter.tutorial.juc.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class PriorityBlockingQueueExample1 {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue();
        queue.offer(1);
        queue.offer(12);
        queue.offer(21);
        queue.offer(6);

        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 6
        System.out.println(queue.poll()); // 12
        System.out.println(queue.poll()); //21

    }
}
