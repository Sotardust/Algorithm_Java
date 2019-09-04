package com.dai.dynamic;

import java.util.ArrayList;

/**
 * 利用动态规划求最大子段和问题
 */
public class LongestCommonSubsequence {

    int[] ints = {2, -4, 11, -3, 5, 16, -4, 1, 7};


    /**
     * 求最大子段和
     *
     * @param ints
     */
    public void sumMaxValue(int[] ints) {
        int sum = 0, result = 0;
        for (int val : ints) {

            if (result > 0) {
                result += val;
            } else {
                result = val;
            }
            if (sum < result) {
                sum = result;
            }
        }
        System.out.println("sum =" + sum);
    }


    /**
     * 分治法求最大字段和
     *
     * @param ints
     * @param left
     * @param right
     * @return
     */
    public int maxSubSum(int[] ints, int left, int right) {
        int sum;
        if (left == right) {
            return ints[left] > 0 ? ints[left] : 0;
        }
        int center = (left + right) / 2;

        int leftSum = maxSubSum(ints, left, center);

        int rightSum = maxSubSum(ints, center + 1, right);

        int s1 = 0, lefts = 0;
        for (int i = center; i >= left; i--) {
            lefts += ints[i];
            if (s1 < lefts) s1 = lefts;
        }
        int s2 = 0, rights = 0;
        for (int i = center + 1; i <= right; i++) {
            rights += ints[i];
            if (s2 < rights) s2 = rights;
        }

        sum = s1 + s2;
        System.out.println("  leftSum = " + leftSum + " rightSum = " + rightSum + " sum = " + sum);
        if (leftSum > sum) sum = leftSum;
        if (rightSum > sum) sum = rightSum;

        System.out.print(sum + " --> ");
        return sum;
    }


    /**
     * 最长公共子序列问题：LCS
     */
    public void commonSequence() {
        int[] ints = {-2, 11, -4, 13, -5, -2};
        int[] ints1 = {5, 11, -4, 13, 6, -2};
        commonSequence(ints, ints1);

    }

    private void commonSequence(int[] a, int[] b) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int index = i;
            boolean bool = false;
            for (int value : b) {
                if (a[index] == value) {
                    ++index;
                    bool = true;
                    temp.add(value);
                } else if (bool) {
                    break;
                }
            }
            if (temp.size() != 0) {
                lists.add(temp);
            }
        }
        System.out.println("\n");
        int index = 0, length = 0;
        for (ArrayList<Integer> list : lists) {
            if (list.size() > length) {
                length = list.size();
                index = lists.indexOf(list);
            }
            System.out.println("list =" + list);
        }
        System.out.println("最长公共子序列 Long list " + lists.get(index));


    }

}
