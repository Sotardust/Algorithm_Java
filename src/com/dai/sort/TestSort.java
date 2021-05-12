package com.dai.sort;

public class TestSort {


    private static int[] arrays = {45, 12, 23, 14, 57, 93, 42, 16, 94, 37, 85};

    public static void main(String[] args) {

        Sort sort = new Sort();

//        sort.bubbleSort();
//        sort.insertSort();
//        sort.heapSort();
//        sort.quickSort();
        sort.selectSort();
    }


    static class Sort {

        //打印带参数组
        void printArray(String sort, int[] ints) {
            StringBuilder sb = new StringBuilder();
            sb.append(ints[0]);
            for (int i = 1; i < ints.length; i++) {
                sb.append(" , ").append(ints[i]);
            }
            System.out.println(sort + " : " + sb);
        }

        /**
         * 冒泡排序
         */
        void bubbleSort() {

            for (int i = 0; i < arrays.length; i++) {
                for (int j = i; j < arrays.length; j++) {
                    if (arrays[i] > arrays[j]) {
                        int temp = arrays[j];
                        arrays[j] = arrays[i];
                        arrays[i] = temp;
                    }
                }
                printArray("冒泡排序：", arrays);
            }
        }

        /**
         * 插入排序
         */
        void insertSort() {

            for (int i = 0; i < arrays.length; i++) {

                int temp = arrays[i];
                int j = i - 1;

                while (j > -1 && temp < arrays[j]) {
                    arrays[j + 1] = arrays[j];
                    j--;

                }
                arrays[j + 1] = temp;
                printArray("插入排序", arrays);
            }

        }

        /**
         * 堆排序
         * 1、构建大或者小根堆
         * 2、将堆顶结点与最后一个结点进行比较
         */
        void heapSort() {

            //构建大根堆
            for (int i = 0; i < arrays.length / 2; i++) {
                heapAdjust(arrays, i, arrays.length - 1);
            }

            for (int i = arrays.length - 1; i > 0; i--) {
                //将堆顶结点与最后一个结点进行比较
                swap(arrays, i, 0);

                //进行堆调整
                heapAdjust(arrays, 0, i - 1);
            }

            printArray("堆排序", arrays);

        }

        /**
         * 堆调整
         */
        void heapAdjust(int[] ints, int root, int length) {
            for (int i = 2 * root + 1; i < length; i++) {
                swap(ints, i, i + 1);
                swap(ints, root, i);
            }
        }

        void swap(int[] ints, int left, int right) {
            if (ints[left] < ints[right]) {
                int temp = ints[right];
                ints[right] = ints[left];
                ints[left] = temp;
            }
        }


        /**
         * 快速排序
         * <p>
         * 快速排序使用分治的思想，通过一趟排序将待排序列分割成两部分，
         * 其中一部分记录的关键字均比另一部分记录的关键字小。
         * 之后分别对这两部分记录继续进行排序，以达到整个序列有序的目的。
         */
        void quickSort() {

            sort(arrays, 0, arrays.length - 1);

        }


        void sort(int[] ints, int low, int high) {
            if (low > high) return;
            int pivot = pivot(ints, low, high);
            sort(ints, low, pivot - 1);
            sort(ints, pivot + 1, high);
        }

        /**
         * 获取基准数据
         * {45, 12, 23, 14, 57, 93, 42, 16, 94, 37, 85}
         */
        int pivot(int[] ints, int low, int high) {
            printArray("快速排序 low = " + low + " , high = " + high, arrays);
            int key = ints[low];
            while (low < high) {
                while (ints[high] >= key && high > low) { //从后半部分扫描
                    high--;
                }
                ints[low] = ints[high];
                while (ints[low] <= key && high > low) {//从前半部分扫描
                    low++;
                }
                ints[high] = ints[low];
            }

            ints[high] = key;
            return high;
        }


        /**
         * 在一个长度为N的无序数组中，在第一趟遍历N个数据，
         * 找出其中最小的数值与第一个元素交换，第二趟遍历剩下的N-1个数据，
         * 找出其中最小的数值与第二个元素交换......第N-1趟遍历剩下的2个数据，
         * 找出其中最小的数值与第N-1个元素交换，至此选择排序完成
         * <p>
         * 选择排序
         * {45, 12, 23, 14, 57, 93, 42, 16, 94, 37, 85}
         */
        void selectSort() {
            for (int i = 0; i < arrays.length; i++) {
                int min = arrays[i];
                for (int j = i; j < arrays.length; j++) {
                    if (min > arrays[j]) {
                        int temp = min;
                        min = arrays[j];
                        arrays[j] = temp;
                    }
                }
                arrays[i] = min;
            }

            printArray("选择排序", arrays);
        }


        void  mergeSort(){

        }

        void merge(int[] ints,int left,int right){

        }

    }
}
