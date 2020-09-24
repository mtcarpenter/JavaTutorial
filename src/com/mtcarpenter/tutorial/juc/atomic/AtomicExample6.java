package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-edu
 * @info 微信公众号：山间木匠
 */
public class AtomicExample6 {
    /**
     * 引用类型 AtomicReference
     */
    private static AtomicReference<Teacher> atomicReference = new AtomicReference<>();

    private static BinaryOperator<Teacher> binaryOperator = new BinaryOperator<Teacher>() {
        @Override
        public Teacher apply(Teacher teacher, Teacher teacher2) {
            // 返回新值
            return teacher2;
        }
    };
    public static void main(String[] args) {
        Teacher teacher = new Teacher("小春哥", 200);
        // 将当前对象设置到引用对象 AtomicReference 中
        atomicReference.set(teacher);
        Teacher updateTeacher = new Teacher("懵懂少年", 180);
        // teacher 和 引用类型AtomicReference 保存的对象一致 则能修改成功
        atomicReference.compareAndSet(teacher, updateTeacher);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getTicketNum());
        Teacher accumulateTeacher = new Teacher("懵懂少年", 210);
        // 原子性地更新指定对象，并且返回AtomicReference更新后的值
        atomicReference.accumulateAndGet(accumulateTeacher, binaryOperator);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getTicketNum());
    }
}
