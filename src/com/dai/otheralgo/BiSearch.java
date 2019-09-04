package com.dai.otheralgo;

public class BiSearch {

    int[] ints = {2, 4, 6, 8, 12, 23, 34, 45, 56, 68, 79};


    public void biSearch() {
        biSearch(ints, 68);
        biSearch(ints, 2);
        biSearch(ints, 4);
        biSearch(ints, 12);

        int mid1 = biSearch(ints, 6, 0, ints.length - 1);
        int mid2 = biSearch(ints, 2, 0, ints.length - 1);
        int mid3 = biSearch(ints, 12, 0, ints.length - 1);
        int mid4 = biSearch(ints, 79, 0, ints.length - 1);
        System.out.println("\n mid1 = " + mid1 + " mid2 = " + mid2 + " mid3 = " + mid3 + " mid4 = " + mid4);
    }

    /**
     * 折半查找，又称二分法查找
     *
     * @param ints
     * @param number
     */
    private void biSearch(int[] ints, int number) {
        int left = 0, right = ints.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (ints[mid] == number) {
                break;
            } else if (ints[mid] > number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("mid =" + mid);
    }

    /**
     * 通过递归实现折半查找
     *
     * @param ints
     * @param number
     * @param left
     * @param right
     * @return 查找所在位置
     */
    private int biSearch(int[] ints, int number, int left, int right) {
        int mid = (left + right) / 2;
        if (ints[mid] == number) {
            return mid;
        } else if (ints[mid] > number) {
            return biSearch(ints, number, left, mid - 1);
        } else {
            return biSearch(ints, number, mid + 1, right);
        }
    }
}
