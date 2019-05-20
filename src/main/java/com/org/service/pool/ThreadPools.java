package com.org.service.pool;

import com.org.data.MyTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPools {
    public static void main(String[] args) {
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        ExecutorService poolExecutor = Executors.newFixedThreadPool(20);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) poolExecutor;
        for (int i = 0; i < 500; i++) {
            MyTask myTask = new MyTask(i);
            threadPoolExecutor.submit(myTask);
            //threadPoolExecutor.execute(myTask);
            System.out.println("\n线程池中的线程数 ： " + threadPoolExecutor.getPoolSize() + "\n队列中等待的任务数目： " + threadPoolExecutor.getQueue().size() + "\n已执行完的线程数目 " + threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
}
