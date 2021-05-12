package com.dai.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExcouteTest {


    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor() ;

        List<Runnable> runnables = new ArrayList<>();
        Runnable runable = new Runnable() {

            @Override
            public void run() {

                System.out.println(" 0 = ");
            }
        };

        Runnable runable1 = new Runnable() {

            @Override
            public void run() {
                System.out.println(" 1 = ");

            }
        };

        Runnable runable2 = new Runnable() {

            @Override
            public void run() {

                System.out.println(" 2 = ");
            }
        };
        Runnable runable3 = new Runnable() {

            @Override
            public void run() {
                System.out.println(" 3 = ");

            }
        };
//        for (int i = 0; i < 10; i++) {
//            runnables.add(runable)
//        }
        runnables.add(runable);
        runnables.add(runable1);
        runnables.add(runable2);
        runnables.add(runable3);

        for (int i = 0; i < 4; i++) {
            service.scheduleWithFixedDelay(runnables.get(i),  0,5000, TimeUnit.MILLISECONDS);
        }


    }

}
