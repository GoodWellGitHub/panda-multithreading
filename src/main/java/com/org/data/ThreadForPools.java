package com.org.data;

public class ThreadForPools implements Runnable {
    private Integer index;

    public ThreadForPools(Integer index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("开始处理线程！！！");
        try {
            Thread.sleep(100 * index);
            System.out.println("我的线程标识是" + this.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
