package com.mtcarpenter.tutorial.juc.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class AtomicExample4 {
    /**
     * 初始化 数组长度为 10
     */
    private static AtomicLongArray arr = new AtomicLongArray(5);

    private static LongUnaryOperator longUnaryOperator = new LongUnaryOperator() {
        @Override
        public long applyAsLong(long operand) {
            // 当前索引 + 10
            return operand + 10;
        }

    };

    private static LongBinaryOperator accumulatorFunction = new LongBinaryOperator() {

        @Override
        public long applyAsLong(long left, long right) {
            return left + right;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < arr.length(); i++) {
            System.out.println("i-" + i + "=" + arr.get(i));
        }

        // 以原子方式给当前索引下标为（0）值加1，返回新值 （i++）： 0
        System.out.println("索引 0 incrementAndGet=" + arr.getAndIncrement(0));
        // 以原子方式给当前索引下标为（0）值加1，，返回新值（++i）  两次增加 ： 2
        System.out.println("索引 0 incrementAndGet=" + arr.incrementAndGet(0));
        //以原子方式给当前索引下标为（0）值减少 1，返回旧值 （i--）：2
        System.out.println("索引 0 incrementAndGet=" + arr.getAndDecrement(0));
        //以原子方式给当前索引下标为（0）值减少 1，返回旧值 （--i）：0
        System.out.println("索引 0 incrementAndGet=" + arr.decrementAndGet(0));
        // 以原子方式将输入的数值与实例中的值（AtomicLongArray（0）里的value）相加，并返回结果 : 100
        System.out.println("索引 0 addAndGet=" + arr.addAndGet(0, 100));
        // 获取 AtomicLongArray 的 value 100
        System.out.println("索引 0 get=" + arr.get(0));

        System.out.println("*********** JDK 1.8 ***********");
        //使用将给定函数应用给当前值和给定值的结果原子更新当前值，返回上一个值
        // 索引下标为 0 执行指定函数 结果为 100 + 10
        System.out.println("索引 0 getAndUpdate=" + arr.updateAndGet(0, longUnaryOperator));
        // 索引下标为 1 执行指定函数 结果为 0 + 10
        System.out.println("索引 1 getAndUpdate=" + arr.updateAndGet(1, longUnaryOperator));
        // 使用给定函数应用给指定下标和给定值的结果原子更新当前值，并返回结果 20
        System.out.println("索引 1 accumulateAndGet=" + arr.accumulateAndGet(1, 10, accumulatorFunction));

    }


}