package com.dai.test;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {
    public static void main(String[] args) {

        final ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                5000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(1000));


        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {

                    Thread thread = Thread.currentThread();
                    System.out.println("execute Thread_name = " + thread.getName() + " Thread_activeCount = " + Thread.activeCount() + " getCorePoolSize: " + executor.getCorePoolSize() + " queue.size =" + executor.getQueue().size());

                }
            });
        }

//        for (int i = 0; i < 100; i++) {
//            executor.submit(new Runnable() {
//                @Override
//                public void run() {
//
//                    Thread thread = Thread.currentThread();
//                    System.out.println("submit Thread_name = " + thread.getName() + " Thread_activeCount = " + Thread.activeCount() + " getCorePoolSize: " + executor.getCorePoolSize() + " queue.size =" + executor.getQueue().size());
//
//                }
//            });
//        }



    }
}
