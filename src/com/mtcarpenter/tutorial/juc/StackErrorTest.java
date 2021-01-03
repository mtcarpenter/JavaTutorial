package com.mtcarpenter.tutorial.juc;

/**
 * <p>
 *
 * </p>
 *
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-edu
 * @info 微信公众号：山间木匠
 * @since 2020/11/2
 */
/**
 * 演示栈中的异常:StackOverflowError
 *  默认情况下：count : 11420
 *  设置栈的大小： -Xss256k : count : 2465
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count++);
        main(args);
    }
}