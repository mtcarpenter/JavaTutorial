package com.mtcarpenter.tutorial.JVMDemo.chapter01.src.com.atguigu.java;

import java.io.File;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-edu
 * @info 微信公众号：山间木匠
 */
public class Test {

    public static void main(String[] args) {
        File file = new File("E:\\BaiduNetdiskDownload\\剑指Java面试-买");
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {
                System.out.println("## "+listFile.getName());
                for (File file1 : listFile.listFiles()) {
                    System.out.println("### "+file1.getName().replace(".mp4", ""));
                }
            }
        }
    }
}
