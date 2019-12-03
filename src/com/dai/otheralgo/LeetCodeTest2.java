package com.dai.otheralgo;

import java.util.*;

public class LeetCodeTest2 {
    public static void main(String[] args) {
//        String s = "LEETCODEISHIRING";
//        convert(s, 3);

//        intToRoman(1994);
//        String[] strings = {"abab", "aba", ""};
//        String result = longestCommonPrefix(strings);
//        System.out.println("result = " + result);
//        String ab = "adbad";
//        System.out.println("ab.substring(0,0) = " + ab.substring(4, 5));
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
//        threeSum(nums);
//        threeSumClosest(nums, 82);
        letterCombinations("23");
    }

    public static String convert(String s, int numRows) {
        int bus = s.length() / (numRows - 1); //商
        int rem = s.length() % (numRows - 1);//余数
        int row = numRows;
        int column = bus * (numRows - 2) + (rem - numRows <= 0 ? 1 : (rem - numRows + 1));
        System.out.println("column = " + column);
        String[][] array = new String[row][column];
        for (int i = 0; i < s.length(); i++) {

            int row1 = i / bus;
            int column1 = bus * (numRows - 2) + (i - numRows <= 0 ? 1 : (i - numRows + 1));
//            array[row1][]
            System.out.println("column1 = " + column1 + "row1 = " + row1);

        }


        return array.toString();
    }

    /**
     * 整数转罗马数字
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {

        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] str = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder builder = new StringBuilder();
        int length = nums.length - 1;
        while (num != 0) {
            if (num >= nums[length]) {
                num -= nums[length];
                builder.append(str[length]);
            } else {
                length--;
            }
        }
        return builder.toString();
    }

    /**
     * 罗马数字转整数
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                result += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                result += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;

    }

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，[-2,0,1,1,2]
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();

            list.add(nums[i]);

            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                if (list.size() == 1) {
                    list.add(nums[j]);
                } else {
                    list.set(1, nums[j]);
                }
                for (int k = 0; k < nums.length; k++) {
                    if (k == j || k == i) continue;
                    if (list.size() == 2) {
                        list.add(nums[k]);
                    } else {
                        list.set(2, nums[k]);
                    }
                    Collections.sort(list);
                    int sum = 0;
                    for (Integer integer : list) {
                        sum += integer;
                    }
                    if (sum == 0) {
                        if (!lists.contains(new ArrayList<>(list))) {
                            lists.add(new ArrayList<>(list));
                        }
                    }
                }
            }
        }
        for (List<Integer> list : lists) {
            System.out.println("list = " + list);
        }
        return lists;

    }

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * <p>
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE, left, right, min = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length - 2; k++) {
            left = k + 1;
            right = nums.length - 1;

            // 区间[left,right]内,和最小的值
            int rangeMin = nums[k] + nums[left] + nums[left + 1];
            // 区间[left,right]内,和最大的值
            int rangeMax = nums[k] + nums[right] + nums[right - 1];
            if (rangeMin > target) {
                // 区间最小值比目标大, 没必要寻找区间其他值的和了
                if (rangeMin - target < min) {
                    min = rangeMin - target;
                    result = rangeMin;
                }
            } else if (rangeMax < target) {
                // 区间最大的值比目标还要小,也没必要寻找区间其他值的和了
                if (target - rangeMax < min) {
                    min = target - rangeMax;
                    result = rangeMax;
                }
            } else {
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[k];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        return sum;
                    }
                    if (Math.abs(sum - target) < min) {
                        result = sum;
                        min = Math.abs(sum - target);
                    }
                }
            }
        }
        return result;

    }

    /**
     * @param nums   {1,2,4,8,16,32,64,128}
     * @param target 82
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, left, right, minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int result = nums[i] + nums[left] + nums[right];
                if (target > result) {
                    left++;
                } else if (target < result) {
                    right--;
                } else {
                    return sum;
                }
                if (Math.abs(target - result) < minValue) {
                    sum = result;
                    minValue = Math.abs(target - result);
                }
            }
        }
        return sum;

    }

    /**
     * 17. 电话号码的字母组合
     * <p>
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    private static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private static List<String> output = new ArrayList<String>();

    public static void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            System.out.println("combination = " + combination);
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            System.out.println("----------------letters = " + letters + "----------------- ");

            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                System.out.println("(combination + letter) = " + combination + letter);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }


}
