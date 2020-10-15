package com.mtcarpenter.tutorial.juc.looks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class LockExample5 {
    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "开始阻塞");
                    condition.await();
                    System.out.println(Thread.currentThread().getName() + "阻塞已经被放开");
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
            }
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "开始阻塞");
                    condition.signalAll();
                    System.out.println(Thread.currentThread().getName() + "阻塞已经被放开");
                } finally {
                    lock.unlock();
                }
            }
        }, "t2").start();
    }
}
