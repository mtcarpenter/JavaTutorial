package com.mtcarpenter.tutorial.JVMDemo.chapter01.src.com.atguigu.java.jvm.model;

public class StackLeakByThread {
    public static void main(String[] args) {
        while (true){
            new Thread() {
                public void run(){
                    while (true){

                    }
                }
            }.start();
        }
    }
}
