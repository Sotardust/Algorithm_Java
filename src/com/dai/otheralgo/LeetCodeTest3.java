package com.dai.otheralgo;

import java.lang.reflect.Array;
import java.util.*;

public class LeetCodeTest3 {
    public static void main(String[] args) {

//        int[] nums = {0, 4, 8, 7, 10, 16};
        int[] nums = {0, 3, 3, 7, 5, 3,11,1};
        int result = solution(nums);
        System.out.println("result = " + result);
    }


    public static int solution(int[] A) {
        int[] nums = A.clone();
        Arrays.sort(nums);
        int minAbs = Integer.MAX_VALUE;
        boolean isExistIndex = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int result = A[i] - A[j];
                if (result == 0) {
                    if (Math.abs(i - j) == 1) {
                        isExistIndex = true;
                    }
                    if (result < minAbs && isExistIndex) {
                        minAbs = result;
                    }
                }
                for (int k = 1; k <= Math.abs(result); k++) {
                    int target = k + (result > 0 ? A[j] : A[i]);
                    if (target < (result > 0 ? A[i] : A[j])) {
                        boolean isExist = Arrays.binarySearch(nums, target) > 0;
                        if (!isExist) {
                            if (Math.abs(i - j) == 1) {
                                isExistIndex = true;
                            }
                            if (Math.abs(result) < minAbs && isExistIndex) {
                                minAbs = Math.abs(result);
                            }
                        }
                    }else {
                        if (Math.abs(result) < minAbs && isExistIndex) {
                            minAbs = Math.abs(result);
                        }
                    }
                }
                if (minAbs == 0) {
                    return 0;
                }
            }
        }
        if (!isExistIndex) {
            return -2;
        }
        if (minAbs > 100000000) {
            return -1;
        }
        return minAbs;
    }
}
