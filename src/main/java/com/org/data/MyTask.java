package com.org.data;

public class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("\n正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(400);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + " 执行结束");
    }
}
