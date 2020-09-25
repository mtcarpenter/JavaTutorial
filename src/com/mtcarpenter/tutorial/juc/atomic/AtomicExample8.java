package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class AtomicExample8 {

    private static AtomicIntegerFieldUpdater<Teacher> integerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Teacher.class, "ticketNum");

    public static void main(String[] args) {
        // 设置懵懂少年 180票
        Teacher teacher = new Teacher("懵懂少年", 180);
        // 180
        System.out.println("getAndIncrement = " + integerFieldUpdater.getAndIncrement(teacher));

        System.out.println("get=" + integerFieldUpdater.get(teacher));
    }
}