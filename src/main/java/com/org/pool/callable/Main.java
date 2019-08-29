package com.org.pool.callable;

import com.org.pool.callable.domain.TaskInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<TaskInfo> taskInfoList = TaskInfo.getTaskInfoList();
        List<Future<TaskInfo>> futureTasks = new ArrayList<Future<TaskInfo>>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        for (int i = 0; i < taskInfoList.size(); i++) {
            RunTask runTask = new RunTask(taskInfoList.get(i));
            Future<TaskInfo> taskInfoFutureTask = executor.submit(runTask);
            futureTasks.add(taskInfoFutureTask);
        }

        while (executor.getCompletedTaskCount() < taskInfoList.size()) {
            try {
                System.out.println("try .....");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("####################");
        System.out.println(executor.getActiveCount());
        for (int i = 0; i < futureTasks.size(); i++) {
            Future<TaskInfo> infoFuture = futureTasks.get(i);
            System.out.println(infoFuture.isDone());
            try {
                System.out.println(infoFuture.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println("执行异常");
            }
        }
        System.out.println(executor.getActiveCount());
        executor.shutdown();

        List<String> strings = new ArrayList<String>(12);
        System.out.println(strings.size());

        FutureTask<Integer> task=new FutureTask(new Runnable() {
            public void run() {
                System.out.println(" ");
            }
        },1);

    }
/*
    public static void main(String[] args) {
        int COUNT_BITS = 29;
        int RUNNING = -1 << COUNT_BITS;
        int SHUTDOWN = 0 << COUNT_BITS;
        int STOP = 1 << COUNT_BITS;
        int TIDYING = 2 << COUNT_BITS;
        int TERMINATED = 3 << COUNT_BITS;

        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);

    }*/


}
