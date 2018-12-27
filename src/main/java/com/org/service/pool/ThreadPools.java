package com.org.service.pool;

import com.org.data.ThreadForPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by huajun.wang01 on 2018/12/27.
 */
public class ThreadPools {
    public static void main(String[] args) {
        //cachedPool();
        //fixedPool();
        //scheduleThreadPool();
        singleThreadPool();
    }

    static void cachedPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("****************************newCachedThreadPool*******************************");
        for (int i = 0; i < 40; i++) {
            final int index = i;
            cachedThreadPool.submit(new ThreadForPools(index));
        }
    }

    static void fixedPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        System.out.println("****************************newFixedThreadPool*******************************");
        for (int i = 0; i < 8; i++) {
            final int index = i;
            fixedThreadPool.submit(new ThreadForPools(index));
        }
    }

    static void scheduleThreadPool() {
        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("****************************newFixedThreadPool*******************************");
        for (int i = 0; i < 4; i++) {
            final int index = i;
            scheduleThreadPool.schedule(new ThreadForPools(index), 3, TimeUnit.SECONDS);
        }
    }

    static void singleThreadPool() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        System.out.println("****************************newFixedThreadPool*******************************");
        for (int i = 0; i < 4; i++) {
            final int index = i;
            singleThreadPool.submit(new ThreadForPools(index));
        }
    }
}
