package com.mtcarpenter.tutorial.JVMDemo.chapter01.src.com.atguigu.java.reflect;

public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        //ClassLoader cl = Robot.class.getClassLoader();
        //Class r = Class.forName("com.interview.javabasic.reflect.Robot");
        Class.forName("com.mysql.jdbc.Driver");
    }
}
