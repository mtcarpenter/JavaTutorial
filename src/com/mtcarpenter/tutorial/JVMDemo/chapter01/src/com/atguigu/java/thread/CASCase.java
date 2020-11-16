package com.mtcarpenter.tutorial.JVMDemo.chapter01.src.com.atguigu.java.thread;

public class CASCase {
    public volatile int value;

    public synchronized void add() {
        value++;
    }
}
