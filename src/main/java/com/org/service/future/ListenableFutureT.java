package com.org.service.future;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ListenableFutureT {
    public static void main(String[] args) {
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> future = listeningExecutorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("call excute");
                TimeUnit.SECONDS.sleep(1);
                return 7;
            }
        });
/*        Futures.addCallback(future, new FutureCallback<Integer>() {
            public void onSuccess(@Nullable Integer result) {
                System.out.println("get listenable future's result with callback ");
            }

            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });*/
    }
}
