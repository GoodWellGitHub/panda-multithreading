package com.org.pool.callable;

import com.org.pool.callable.domain.TaskInfo;

import java.util.concurrent.Callable;

public class RunTask implements Callable<TaskInfo> {
    private TaskInfo taskInfo;

    public RunTask(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    public TaskInfo call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "   " + taskInfo.toString() + " is running ");
        if (taskInfo.getId() == 1) {
            throw new StringIndexOutOfBoundsException(1);
        }
        Thread.sleep(taskInfo.getSleep());
        return taskInfo;
    }
}
