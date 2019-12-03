package com.dai.test;

import java.util.*;

public class TestList {
    public static void main(String[] args) {


        Vector<String> vector = new Vector<>();
        ArrayList<String> list = new ArrayList<>();
        vector.add("dsfa");

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        for (int i = 0; i < 20; i++) {
            linkedHashMap.put(i + "", "数据" + i);
        }
//        test();
        for (String entry:linkedHashMap.keySet()) {
            System.out.println("entry = " + entry+" , value = "+linkedHashMap.get(entry));
        }

        System.out.println("linkedHashMap = " + linkedHashMap);



    }

    private static void test() {
        int total = 10000000;

        long time1 = System.currentTimeMillis();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            list.add("数据" + i);
        }

        long time2 = System.currentTimeMillis();

        System.out.println("add 耗时 = " + (time2 - time1));

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            list.remove(random.nextInt(total));
        }

        long time3 = System.currentTimeMillis();

        System.out.println("remove 耗时 = " + (time3 - time2));

        String value = list.get(23576);

        long time4 = System.currentTimeMillis();

        System.out.println("value = " + value + " get 耗时 = " + (time4 - time3));

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            linkedList.add("数据" + i);
        }

        long time5 = System.currentTimeMillis();

        System.out.println("add 耗时 = " + (time5 - time4));
        Random random1 = new Random();
        for (int i = 0; i < 1000; i++) {
            linkedList.remove(random1.nextInt(total));
        }

        long time6 = System.currentTimeMillis();

        System.out.println("remove 耗时 = " + (time6 - time5));

        String value1 = linkedList.get(23576);

        long time7 = System.currentTimeMillis();

        System.out.println("value1 = " + value1 + " get 耗时 = " + (time7 - time6));


        list.add(88888, "ceshi");

        long time8 = System.currentTimeMillis();

        System.out.println(" list add 耗时 = " + (time8 - time7));

        linkedList.add(88888, "ceshi");

        long time9 = System.currentTimeMillis();

        System.out.println(" linkedList add 耗时 = " + (time9 - time8));
    }

}
