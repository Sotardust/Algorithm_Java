package com.dai.otheralgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCodeTest {

    private static Node node1;
    private static Node node2;

    public static void main(String[] args) {



//        node1 = new Node(2);
//        addNode1(3);
//        addNode1(4);
//        addNode1(2);
//        addNode1(9);
//
//        addNode2(7);
//        addNode2(6);
//        addNode2(5);
//        sumLink(node1, node2);

//        String str1 = "abcabcbb";
//        String str2 = "bbbbb";
//        String str3 = "pwwkew";
//        String str4 = "aabaab!bb";
//
//        lengthOfLongestSubstring(str1);
//        lengthOfLongestSubstring(str2);
//        lengthOfLongestSubstring(str3);
//        lengthOfLongestSubstring(str4);
//        test1();
    }


    public static void test1() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        search(nums, 9);

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
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
        printArray("sums  ", sums);

    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int index = 0;
        boolean flag = false;
        while (index < s.length()) {

            if (!sb.toString().contains(String.valueOf(s.charAt(index)))) {
                sb.append(s.charAt(index));

                if (flag) {
                    sb.delete(0, 1);
                }
                flag = false;
            } else {
                sb.append(s.charAt(index));
                list.add(sb.toString());
                flag = true;

            }
            index++;
        }

        return sb.toString();
    }

    private static boolean isEquls(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring(String s) {
        StringBuilder builder = new StringBuilder();
        int index = 0, maxLength = 0;
        while (index < s.length()) {
            String value = String.valueOf(s.charAt(index++));
            int indexOf = builder.indexOf(value);
            System.out.println("builder = " + builder.toString() + ", value = " + value + ", indexOf = " + indexOf);
            if (indexOf != -1) {
                builder.delete(0, indexOf + 1);
            }
            builder.append(value);
            if (maxLength < builder.length()) {
                maxLength = builder.length();
            }
        }
        System.out.println("LeetCodeTest.lengthOfLongestSubstring maxLength = " + maxLength);
        return maxLength;
    }

    /**
     * 输出链表元素
     */
    public static void printLinkedList(Node head) {
        System.out.println("\n");
        int size = getSize(head);
        if (size > 0) {
            Node node = head;
            int length = size;
            while (length > 0) {
                if (length == 1) {
                    System.out.print(node.num + "\n");
                } else {
                    System.out.print(node.num + " --> ");
                }
                node = node.next;
                length--;
            }
            System.out.println("\n");
        } else {
            System.out.println("[]");
        }
    }

    /**
     * 获取链表长度
     *
     * @return size
     */
    public static int getSize(Node node) {
        System.out.println("\n");
        int size = 0;
        while (node != null) {
            System.out.print(node.num + " --> ");
            node = node.next;
            ++size;
        }
        return size;
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void sumLink(Node node1, Node node2) {

        Node dummyHead = new Node(0);
        Node p = node1, q = node2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.num : 0;
            int y = (q != null) ? q.num : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;

            getSize(curr);
            getSize(dummyHead);
        }
        if (carry > 0) {
            curr.next = new Node(carry);
        }
        getSize(node1);
        getSize(node2);

        getSize(dummyHead.next);

    }

    public static void addNode1(int data) {
        Node temp = new Node(data);
        temp.next = node1;
        node1 = temp;
//        getSize(node1);
    }

    public static void addNode2(int data) {
        Node temp = new Node(data);
        temp.next = node2;
        node2 = temp;
        getSize(node2);
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
        int value = (temp[temp.length / 2]);
        if (temp.length != 1) {
            value += temp[temp.length / 2 - 1];
        }
        if (temp.length % 2 == 0) {
            return (double) ((float) value / 2);
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
