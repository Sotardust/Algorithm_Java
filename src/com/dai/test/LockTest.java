package com.dai.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static  int count = 0;
    private final Lock lock = new ReentrantLock();

    AddTest test = new AddTest();

    class addHundredNum extends Thread {
        @Override
        public void run() {
//            test.testStatic();
//            test.testStatic();
            AddTest.testStatic();

            //...执行其他操作
//            synchronized (addHundredNum.class) {

//            lock.lock();
//            for (int i = 0; i < 10000000; i++) {
//                count++;
//            }
//            }

//            lock.unlock();
            //...执行其他操作
        }
    }

    static class AddTest {

      static synchronized void testStatic() {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }

        synchronized void test() {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }

        void testA() {
            synchronized (AddTest.class) {

                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        }

    }


    public void test() throws InterruptedException {
        addHundredNum[] addHundredNums = new addHundredNum[100];
        for (int i = 0; i < addHundredNums.length; i++) {
            addHundredNums[i] = new addHundredNum();
        }

        for (addHundredNum addHundredNum : addHundredNums) {
            addHundredNum.start();
        }
        // 等待所有addHundredNum线程执行完毕
        for (addHundredNum addHundredNum : addHundredNums) {
            addHundredNum.join();
        }
    }

    public static void main(String[] args) throws Exception {
        LockTest example = new LockTest();
        long time = System.currentTimeMillis();

        example.test();
        System.out.println("结果值：" + example.count + " , 耗时：" + (System.currentTimeMillis() - time) + " ms");
    }

}

