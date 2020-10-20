package com.mtcarpenter.tutorial.juc.queue;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class DelayQueueExample1 {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedEntry> queue = new DelayQueue<>();
        // 延期3秒 处理
        queue.put(new DelayedEntry("A", 30000L));
        // 延期10 秒处理
        queue.add(new DelayedEntry("B", 10000L));
        // 延期 20 秒处理
        queue.add(new DelayedEntry("C", 20000L));
        int size = queue.size();
        System.out.println("当前时间是：" + LocalDateTime.now());
        // 从延时队列中获取元素， 将输出 A，B，C
        for (int i = 0; i < size; i++) {
            System.out.println(queue.take() + " ------ " + LocalDateTime.now());
        }
    }
}

/**
 * 继承 Delayed 接口
 */
class DelayedEntry implements Delayed {
    /**
     * 元素数据内容
     */
    private final String value;
    /**
     * 用于计算失效时间
     */
    private final long exeTime;

    DelayedEntry(String value, long exeTime) {
        this.value = value;
        this.exeTime = exeTime + System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return exeTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedEntry t = (DelayedEntry) o;
        if (this.exeTime < t.exeTime) {
            return -1;
        } else if (this.exeTime > t.exeTime) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return "DelayedEntry{" +
                "value=" + value +
                ", exeTime=" + exeTime +
                '}';
    }
}

