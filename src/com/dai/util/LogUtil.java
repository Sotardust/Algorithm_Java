package com.dai.util;

public enum LogUtil {
    INSTANC;

    //打印带参数组
    public  void printArray(String sort, int[] ints) {
        StringBuilder sb = new StringBuilder();
        sb.append(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            sb.append(" , ").append(ints[i]);
        }
        System.out.println(sort + " : " + sb);
    }
}
