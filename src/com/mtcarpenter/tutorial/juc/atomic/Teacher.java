package com.mtcarpenter.tutorial.juc.atomic;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/JavaTutorial
 * @info 微信公众号：山间木匠
 */
public class Teacher {

    /**
     * 教师名称
     */
    public volatile String name;

    /**
     * 学生投票数
     */
    public volatile int ticketNum;

    public Teacher(String name, int ticketNum) {
        this.name = name;
        this.ticketNum = ticketNum;
    }

    public String getName() {
        return name;
    }

    public int getTicketNum() {
        return ticketNum;
    }
}
