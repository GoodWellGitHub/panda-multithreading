package com.org.pool.callable.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorSubmit {
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    public void doTask() {
        List<Future<Integer>> infoTaskList = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            infoTaskList.add(executor.submit(new InfoTask(i)));
        }

        System.out.println("完成数量 "+executor.getCompletedTaskCount());

        while (executor.getCompletedTaskCount() < 1000) {

            System.out.println("完成数量 "+executor.getCompletedTaskCount());

            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("完成数量 "+executor.getCompletedTaskCount());
        for (Future<Integer> fu:infoTaskList){
            try {
                System.out.println(fu.get(9, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }


}
