package com.org.pool.callable.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

public class InfoTask implements Callable<Integer> {
    private int num;

    public InfoTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        if (num == 100) {
            throw new TimeoutException();
        }
        return num;
    }
}
