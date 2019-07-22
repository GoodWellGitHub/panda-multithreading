package com.org.pool.callable.domain;


import java.util.ArrayList;
import java.util.List;

public class TaskInfo {
    private int sleep;
    private String desc;
    private int id;

    public TaskInfo(int sleep, String desc, int id) {
        this.sleep = sleep;
        this.desc = desc;
        this.id = id;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<TaskInfo> getTaskInfoList() {
        TaskInfo taskInfo1 = new TaskInfo(5000, "睡眠5000 ms", 1);
        TaskInfo taskInfo2 = new TaskInfo(5000, "睡眠4000 ms", 2);
        TaskInfo taskInfo3 = new TaskInfo(5000, "睡眠1000 ms", 3);
        TaskInfo taskInfo4 = new TaskInfo(5000, "睡眠2000 ms", 5);
        TaskInfo taskInfo5 = new TaskInfo(5000, "睡眠9000 ms", 6);
        TaskInfo taskInfo6 = new TaskInfo(5000, "睡眠12000 ms", 7);
        TaskInfo taskInfo7 = new TaskInfo(5000, "睡眠500 ms", 8);

        List<TaskInfo> taskInfos = new ArrayList<TaskInfo>(12);
        taskInfos.add(taskInfo1);
        taskInfos.add(taskInfo2);
        taskInfos.add(taskInfo3);
        taskInfos.add(taskInfo4);
        taskInfos.add(taskInfo5);
        taskInfos.add(taskInfo6);
        taskInfos.add(taskInfo7);

        return taskInfos;

    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                "sleep=" + sleep +
                ", desc='" + desc + '\'' +
                ", id=" + id +
                '}';
    }
}
