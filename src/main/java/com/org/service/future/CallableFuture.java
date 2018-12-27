package com.org.service.future;

import com.org.data.CallableTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by huajun.wang01 on 2018/12/27.
 */
public class CallableFuture {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        CallableTask task = new CallableTask();
        Future<Integer> future = cachedThreadPool.submit(task);
        cachedThreadPool.shutdown();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行");
        try {
            System.out.println("运行结果：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}
