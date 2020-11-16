package com.mtcarpenter.tutorial.JVMDemo.chapter01.src.com.atguigu.java.jvm.gc;

public class NormalObject {
    public String name;
    public NormalObject(String name){
        this.name = name;
    }

    @Override
    protected void finalize(){
        System.out.println("Finalizing obj " + name);
    }

}
