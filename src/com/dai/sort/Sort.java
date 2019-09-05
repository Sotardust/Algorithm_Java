package com.dai.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 八大排序算法
 */
public class Sort {

    public int[] getInts() {
        return ints;
    }

    private int[] ints = new int[10];
    private Random random = new Random();

    public Sort() {
        resetInts();
    }

    //重置数据
    private void resetInts() {
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(5 * ints.length) % (5 * ints.length - 1 + 1) + 1;
        }
    }

    //打印带参数组
    public void printArray(String sort, int[] ints) {
        StringBuilder sb = new StringBuilder();
        sb.append(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            sb.append(" , ").append(ints[i]);
        }
        System.out.println(sort + " : " + sb);
    }

    /**
     * 冒泡排序算法
     */
    public void bubbleSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
                printArray("bubbleSort", ints);
            }
            System.out.println("---------------------------------------------------");
        }
    }

    /**
     * 优化冒泡排序算法
     */
    public void optimizeBubbleSort(int[] ints) {
        int index = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = index; i < ints.length - 1; i++) {
                if (ints[i] > ints[i + 1]) {
                    int temp = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = temp;
                    flag = true;
                }
                printArray("optimize bubbleSort ", ints);
            }
            System.out.println("---------------------------------------------------");
            ++index;
        }
    }

    /**
     * 插入排序算法
     *
     * @param ints {2, -4, 11, -3, 5, 16, -4, 1, 7};
     */
    public void insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int temp = ints[i];
            int j = i - 1;
            while (j > -1 && temp < ints[j]) {
                ints[j + 1] = ints[j];
                j--;
                printArray("insertSort", ints);
            }
            ints[j + 1] = temp;
            System.out.println("---------------------------------------------------");
        }
    }

    /**
     * 快速排序算法 是对冒泡排序的一种改进。采用分治策略
     */
    public void quickSort(int[] ints) {
        quickSort(ints, 0, ints.length - 1);
    }

    //int[] int1 = {2, -4, 11, -3, 5, 16, -4, 1, 7};
    private int pivot(int[] ints, int low, int high) {
        int key = ints[low];
        while (low < high) {
            while (ints[high] >= key && high > low) { //从后半部分向前扫描
                high--;
            }
            ints[low] = ints[high];
            while (ints[low] <= key && low < high) { //从前半部分向后扫描
                low++;
            }
            ints[high] = ints[low];
            printArray("pivot", ints);
        }
        ints[high] = key;
        System.out.println(" low: " + low + " high: " + high + "-------------------------------");
        return high;
    }

    private void quickSort(int[] ints, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = pivot(ints, low, high);
        quickSort(ints, low, pivot - 1);
        quickSort(ints, pivot + 1, high);
    }

    /**
     * 在一个长度为N的无序数组中，在第一趟遍历N个数据，
     * 找出其中最小的数值与第一个元素交换，第二趟遍历剩下的N-1个数据，
     * 找出其中最小的数值与第二个元素交换......第N-1趟遍历剩下的2个数据，
     * 找出其中最小的数值与第N-1个元素交换，至此选择排序完成
     * <p>
     * 选择排序
     */
    public void selectSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int min = ints[i];
            for (int j = i; j < ints.length; j++) {
                if (min > ints[j]) {
                    int temp = min;
                    min = ints[j];
                    ints[j] = temp;
                }
                printArray("selectSort ", ints);
            }
            ints[i] = min;
            System.out.println("----------------------------------------");
        }
    }

    /**
     * 归并排序（Merge）是将两个（或两个以上）有序表合并成一个新的有序表，
     * 即把待排序序列分为若干个子序列，每个子序列是有序的。
     * 然后再把有序子序列合并为整体有序序列。
     * <p>
     * 归并排序是建立在归并操作上的一种有效的排序算法。
     * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用
     *
     * @param ints {2, -4, 11, -3, 5, 16, -4, 1, 7};
     * @param ints {-4, -3, 2, 11 },{-4, 1, 5, 7, 16};
     */
    public void mergeSort(int[] ints) {
        mergeSort(ints, 0, ints.length - 1);
    }

    private void mergeSort(int[] ints, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(ints, low, mid);
        mergeSort(ints, mid + 1, high);
        merge(ints, low, mid, high);
        printArray("mergeSort", ints);
        System.out.println("----------------------------------------------");
    }

    private void merge(int[] ints, int low, int center, int high) {
        int[] temp = new int[ints.length];
        int mid = center + 1;
        int tempIndex = low;
        int index = low;
        while (low <= center && mid <= high) {
            if (ints[low] <= ints[mid]) {
                temp[index++] = ints[low++];
            } else {
                temp[index++] = ints[mid++];
            }
        }
        while (low <= center) {
            temp[index++] = ints[low++];
        }
        while (mid <= high) {
            temp[index++] = ints[mid++];
        }

        while (tempIndex <= high) {
            ints[tempIndex] = temp[tempIndex++];
        }
        printArray("merge temp", temp);
        printArray("merge ints", ints);

    }


    // 数组交换 升序
    private void swap(int[] a, int index1, int index2) {
        if (a[index1] < a[index2]) {
            int temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }
    }

    /**
     * 1、构建大或者小根堆
     * 2、将堆顶结点与最后一个结点进行比较
     * <p>
     * 堆排序算法
     */
    public void heapSort(int[] ints) {
        for (int i = 0; i < ints.length / 2; i++) {
            heapAdjust(ints, i, ints.length - 1);
        }
        for (int i = ints.length - 1; i > 0; i--) {
            swap(ints, i, 0);
            heapAdjust(ints, 0, i - 1);
            printArray("heapSort ", ints);
            System.out.println("-----------------------------------------");
        }
    }

    /**
     * 堆调整
     *
     * @param ints   {2, -4, 11, -3, 5, 16, -4, 1, 7};
     * @param root   根节点
     * @param length 长度
     */
    private void heapAdjust(int[] ints, int root, int length) {
        for (int i = 2 * root + 1; i < length; i++) {
            swap(ints, i, i + 1);
            swap(ints, root, i);
            printArray("heapAdjust ", ints);
        }
    }

    /**
     * 希尔排序(Shell Sort)是插入排序的一种。
     * 也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。
     * 希尔排序是非稳定排序算法
     *
     * @param ints {2, -4, 11, -3, 5, 16, -4, 1, 7};
     */
    public void shellSort(int[] ints) {
        int gap = ints.length / 2;
        while (1 <= gap) {
            for (int i = gap; i < ints.length; i++) {
                int temp = ints[i], j;
                for (j = i - gap; j >= 0 && temp < ints[j]; j = j - gap) {
                    ints[j + gap] = ints[j];
                }
                ints[j + gap] = temp;
            }
            gap = gap / 2;
        }
        printArray("shellSort", ints);
    }

}
