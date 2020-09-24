package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class AtomicExample7 {

    /**
     * 引用类型 AtomicReferenceFieldUpdater
     */
    private static AtomicReferenceFieldUpdater referenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Teacher.class, String.class, "name");


    public static void main(String[] args) {
        Teacher teacher = new Teacher("小春哥", 200);

        referenceFieldUpdater.compareAndSet(teacher, "小春哥", "公众号:山间木匠");

        System.out.println("修改后的name为:" + teacher.getName());
        System.out.println("修改后的票数为:" + teacher.getTicketNum());

    }

}