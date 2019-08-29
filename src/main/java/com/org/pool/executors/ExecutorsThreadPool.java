package com.org.pool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorsThreadPool {
    static ExecutorService threadPool = Executors.newFixedThreadPool(1, r -> {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(
                (t1, e) -> System.out.println(e));
        return t;
    });

    public static void main(String[] args) {
        threadPool.submit(() -> {
            Object object = null;
            System.out.println(object.toString());
        });
    }
}
