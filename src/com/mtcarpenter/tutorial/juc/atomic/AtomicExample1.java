package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class AtomicExample1 {
    /**
     * 初始化为 0
     */
    private static AtomicLong count = new AtomicLong(0);
    private static LongUnaryOperator longUnaryOperator = new LongUnaryOperator() {
        @Override
        public long applyAsLong(long operand) {
            return 1;
        }
    };
    private static LongBinaryOperator longBinaryOperator = new LongBinaryOperator() {
        @Override
        public long applyAsLong(long left, long right) {
            return left + right;
        }
    };

    public static void main(String[] args) {
        // 以原子方式将当前值加1，返回旧值 （i++）： 0
        System.out.println("getAndIncrement=" + count.getAndIncrement());
        // 以原子方式将当前值加1，返回新值（++i）  两次增加 ： 2
        System.out.println("incrementAndGet=" + count.incrementAndGet());
        //以原子方式将当前值减少 1，返回旧值 （i--）：2
        System.out.println("incrementAndGet=" + count.getAndDecrement());
        //以原子方式将当前值减少 1，返回旧值 （--i）：0
        System.out.println("incrementAndGet=" + count.decrementAndGet());
        // 以原子方式将输入的数值与实例中的值（AtomicLong里的value）相加，并返回结果
        System.out.println("addAndGet=" + count.addAndGet(10));
        // 以原子方式设置为`newValue`的值，并返回旧值
        System.out.println("getAndSet=" + count.getAndSet(100));
        // 获取 atomicLong 的 value
        System.out.println("get=" + count.get());
        System.out.println("*********** JDK 1.8 ***********");
        // 使用将给定函数定函数的结果原子更新当前值，返回上一个值
        // count.get() 为 1：返回 1
        System.out.println("getAndUpdate=" + count.getAndUpdate(longUnaryOperator));
        // 返回 applyAsLong 得值
        System.out.println("getAndUpdate=" + count.getAndUpdate(longUnaryOperator));
        // 获取 atomicLong 的 value
        System.out.println("get=" + count.get());
        // 使用给定函数应用给当前值和给定值的结果原子更新当前值，返回上一个值
        // 返回结果 1，上次结果
        System.out.println("getAndAccumulate=" + count.getAndAccumulate(2, longBinaryOperator));
        // 返回结果 3 ，上次结果 1 + 2
        System.out.println("getAndAccumulate=" + count.getAndAccumulate(2, longBinaryOperator));
        // 获取 atomicLong 的 value
        System.out.println("get=" + count.get());
    }
}