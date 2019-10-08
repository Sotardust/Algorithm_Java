package com.dai.otheralgo;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeTest2 {
    public static void main(String[] args) {
//        String s = "LEETCODEISHIRING";
//        convert(s, 3);

//        intToRoman(1994);
        String[] strings = {"abab", "aba", ""};
        String result = longestCommonPrefix(strings);
        System.out.println("result = " + result);
        String ab = "adbad";
        System.out.println("ab.substring(0,0) = " + ab.substring(4, 5));
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
}
