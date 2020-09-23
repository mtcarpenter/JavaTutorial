package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class AtomicExample5 {


    public static void main(String[] args) {
        /**
         * 初始化 数组
         */
        long arrs[] = {5, 20, 30, 40, 50};
        /**
         * 将初始化数组的值 赋值给 AtomicLongArray
         */
        AtomicLongArray arr = new AtomicLongArray(arrs);

        System.out.println("arr length=" + arr.length());
        for (int i = 0; i < arr.length(); i++) {
            System.out.println("i-" + i + "=" + arr.get(i));
        }

        // 通过set 给指定元素赋值
        arr.set(0, 10);
        // 通过 get 获取下标为 0 的值
        System.out.println("索引 0 get = " + arr.get(0));

        //如果"指定索引的值" =  "预期值" 就将指定的值更新为需要"更新的值"
        // 索引为 2 如果是 20 则相等，将值更新为 30
        arr.compareAndSet(2, 30, 300);
        System.out.println("compareAndSet 更新索引 2 的值= " + arr.get(2));
        // 与 compareAndSet  不管初始值是否为预期值都可能会无法更新该值。
        arr.weakCompareAndSet(2, 300, 3000);
        System.out.println("weakCompareAndSet 更新索引 2 的值= " + arr.get(2));


    }


}