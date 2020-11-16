package com.mtcarpenter.tutorial.JVMDemo.chapter08.src.com.atguigu.java;

/**
 * -Xms10m -Xmx10m
 *
 * @author shkstart  shkstart@126.com
 * @create 2020  16:41
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }

}
