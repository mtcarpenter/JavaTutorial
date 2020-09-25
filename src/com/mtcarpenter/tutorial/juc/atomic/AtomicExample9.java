package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class AtomicExample9 {

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(99, 1);


    public static void main(String[] args) {
        Thread student1 = new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "---首次 stamp： " + stamp);

            atomicStampedReference.compareAndSet(99, 100,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "---第二次 stamp： " + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(100, 99,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "---第三次 stamp： " + atomicStampedReference.getStamp());
        }, "student1");

        Thread student2 = new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "---第一次 stamp： " + stamp);
            try {
                System.out.println(Thread.currentThread().getName() + "---你的校园网正在尝试重新连接......");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(99, 100,
                    stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "---修改成功与否：" + result + "  当前 stamp：" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "---当前课程已选人数：" + atomicStampedReference.getReference());
        }, "student2");

        student1.start();
        student2.start();
    }


}
