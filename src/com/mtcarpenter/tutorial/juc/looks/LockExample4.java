package com.mtcarpenter.tutorial.juc.looks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class LockExample4 {


    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始阻塞");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "阻塞已经被放开");
            }
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始");
                LockSupport.unpark(t1);
                System.out.println(Thread.currentThread().getName() +"阻塞已经被放开");
            }
        }, "t2").start();
    }

}