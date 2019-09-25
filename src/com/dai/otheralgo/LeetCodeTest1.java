package com.dai.otheralgo;

import com.dai.util.LogUtil;

import java.util.Stack;

public class LeetCodeTest1 {

    public static void main(String[] args) {

//        reverse(-654871);
//        reverse1(-654871);
//        int result = myAtoi("-91283472332");
//        int result1 = myAtoi("fdsa-42abd");
//        int result2 = myAtoi("+1");
//        System.out.println("result = " + result);
//        System.out.println("result1 = " + result1);
//        System.out.println("result2 = " + result2);
        boolean result = isPalindrome(304);
        System.out.println("result = " + result);
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        boolean isNegNum = false;
        String value = String.valueOf(Math.abs(x));
        if (x <= 0) {
            isNegNum = true;
        }
        char[] chars = new char[value.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = value.charAt(chars.length - 1 - i);
        }
        value = isNegNum ? "-" + String.valueOf(chars) : String.valueOf(chars);
        int result = 0;
        try {
            result = Integer.parseInt(value);
        } catch (Exception e) {
            return result;
        }
        System.out.println("result = " + result);
        return result;
    }

    public static int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        System.out.println("rev = " + rev);
        return rev;
    }

    public static int myAtoi(String str) {
        str = str.trim();
        boolean isNum = false; //是否为整数
        boolean isFirst = false; //是否为第一次
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (isFirst && sb.length() == 0) {
                return 0;
            }
            if (c >= 48 && c <= 57) {
                if (isNum) {
                    int val = Integer.parseInt(sb.toString());
                    int rem = Integer.parseInt(sb.toString()) % 10;
                    if (val >= Integer.MAX_VALUE / 10)
                        return Integer.MAX_VALUE;
                    if (val <= Integer.MIN_VALUE / 10)
                        return Integer.MIN_VALUE;
                }
                isNum = true;
                sb.append(c);
            } else if (c == 45) {
                if (isNum) {
                    break;
                }
                if (sb.toString().contains("+")) {
                    return 0;
                }
                if (!sb.toString().equals("-")) {
                    sb.append("-");
                }
            } else if (c == 43) {
                if (sb.toString().contains("-")) {
                    return 0;
                }
                sb.append("+");
            } else {
                if (isNum) {
                    return Integer.parseInt(sb.toString());
                }
                isNum = false;
            }
            if (!isFirst) {
                isFirst = true;
            }
        }
        if (sb.length() != 0 && (!"-".equals(sb.toString()) || !"+".equals(sb.toString()))) {
            return Integer.parseInt(sb.toString());
        }
        return 0;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * 进阶:
     * <p>
     * 你能不将整数转为字符串来解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * 说明:
     * <p>
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     *
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {


        return true;
    }
}
