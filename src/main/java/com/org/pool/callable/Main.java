package com.org.pool.callable;

import com.org.pool.callable.domain.TaskInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

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

    }
}
