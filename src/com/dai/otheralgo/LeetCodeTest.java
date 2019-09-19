package com.dai.otheralgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCodeTest {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        search(nums, 9);

        int[] nums1 = {1, 3, 4, 9, 111, 123};
        int[] nums2 = {2, 5};
        double index = findMedianSortedArrays(nums1, nums2);
        System.out.println("index = " + index);
        int[] bills = {5, 5, 5, 10, 20};
        int[] bills1 = {5, 5, 10};
        int[] bills2 = {10, 10};
        int[] bills3 = {5, 5, 10, 10, 20};
        int[] bills4 = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};

        boolean bool = lemonadeChange(bills);
        boolean bool1 = lemonadeChange(bills1);
        boolean bool2 = lemonadeChange(bills2);
        boolean bool3 = lemonadeChange(bills3);
        boolean bool4 = lemonadeChange(bills4);
        System.out.println("bool = " + bool + " , bool1 = " + bool1 + " , bool2 = " + bool2 + " , bool3 = " + bool3 + " , bool4 = " + bool4);
        combinationSum3(3, 5);
        combinationSum3(3, 7);
        combinationSum3(3, 9);
        combinationSum3(3, 10);
        int[] nums3 = {2, 7, 11, 15, 4, 14};
        int[] sums = twoSum(nums3, 18);
        printArray("sums  " ,sums);

    }

    /**
     * 求 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
//        int[] sums = new int[2];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    sums[0] = i;
//                    sums[1] = j;
//                }
//            }
//        }
//        printArray("twoSum", sums);
//        return sums;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp), i};
            }
            hashMap.put(nums[i], i);

        }
        return new int[]{-1, -1};
    }


    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     * <p>
     * 说明：
     * <p>
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     * <p>
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     * <p>
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     *
     * @param k 深度优先搜索
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] nums1 = {{1, 2, 3}, {1, 2, 4}, {1, 2, 5}, {1, 2, 6}, {1, 2, 7}, {1, 2, 8}, {1, 2, 9}};
        int[][] nums2 = {{1, 3, 4}, {1, 3, 5}, {1, 3, 6}, {1, 3, 7}, {1, 3, 8}, {1, 3, 9}};
        int[][] nums3 = {{1, 4, 5}, {1, 4, 6}, {1, 4, 7}, {1, 4, 8}, {1, 4, 9}};
        int[][] nums4 = {{1, 5, 6}, {1, 5, 7}, {1, 5, 8}, {1, 5, 9}};
        int[][] nums5 = {{1, 6, 7}, {1, 6, 8}, {1, 6, 9}};
        int[][] nums6 = {{1, 7, 8}, {1, 7, 9}};
        int[][] nums7 = {{1, 8, 9}};

        List<List<Integer>> lists = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            List<Integer> list = new ArrayList<>();
            for (int m = 1; m < 10; m++) {
                for (int i = 1; i < 10; i++) {
                    if (list.size() < k && !list.contains(i)) {
                        list.add(i);
                    } else {
                        break;
                    }
//                    System.out.println("list = " + list);
                    if (list.size() == k) {
                        int sum = 0;
                        for (int value : list) {
                            sum += value;
                        }
                        if (sum == n) {
                            lists.add(list);
                            break;
                        } else if (sum > n) {
                            break;
                        } else {
                            list.remove(k - 1 - j);
                        }
                    }
                }
            }
        }
        System.out.println("lists = " + lists);

        return lists;
    }

    private void robot(int index, int k, int n, int j) {
//        if (index >= k) {
//            List<Integer> temp = new ArrayList<>();
//            int sum = 0;
//            for (int i = 0; i < k; i++) {
//                sum += paths[i];
//                temp.add(paths[i]);
//            }
//            if (sum == n) {
//                ans.add(temp);
//            }
//            return;
//        }
//        for (int i = j; i <= 9; i++) {
//            paths[index] = i;
//            robot(index + 1, k, n, i + 1);
//        }

    }


    public static int search(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                index = mid;
                break;
            }
            System.out.println("Main.search mid = " + mid);
        }
        System.out.println("Main.search index = " + index);
        return index;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int left1 = 0, right1 = nums1.length - 1;
        int left2 = 0, right2 = nums2.length - 1;
        int index = 0;
        while (left1 <= right1 && left2 <= right2) {
            if (nums1[left1] < nums2[left2]) {
                temp[index++] = nums1[left1++];
            } else {
                temp[index++] = nums2[left2++];
            }
        }
        printArray("temp", temp);
        while (left1 <= right1) {
            temp[index++] = nums1[left1++];
        }
        printArray("temp1", temp);
        while (left2 <= right2) {
            temp[index++] = nums2[left2++];
        }
        printArray("temp2", temp);
        int length = temp.length;
        double value = (temp[temp.length / 2] + temp[temp.length / 2 - 1]);
        if (length % 2 == 0) {
            return value;
        } else {
            return temp[temp.length / 2];
        }
    }

    //打印带参数组
    public static void printArray(String sort, int[] ints) {
        StringBuilder sb = new StringBuilder();
        sb.append(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            sb.append(" , ").append(ints[i]);
        }
        System.out.println(sort + " : " + sb);
    }

    public static boolean lemonadeChange(int[] bills) {

        int left = 0, right = bills.length - 1;
        int record5 = 0;
        int record10 = 0;

        while (left <= right) {
            if (bills[left] == 10) {
                if (record5 < 1) {
                    return false;
                }
                record5--;
                record10++;
            } else if (bills[left] == 20) {
                if ((record5 >= 1 && record10 >= 1)) {
                    record5--;
                    record10--;
                } else if (record5 >= 3) {
                    record5 -= 3;
                } else {
                    return false;
                }
            } else {
                record5++;
            }
            left++;
        }
        return true;
    }


}
