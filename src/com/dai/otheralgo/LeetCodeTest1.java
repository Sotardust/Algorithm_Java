package com.dai.otheralgo;

import java.util.Stack;

public class LeetCodeTest1 {

    public static void main(String[] args) {

        reverse(-654871);
        reverse1(-654871);
        int result = myAtoi("-91283472332");
        int result1 = myAtoi("fdsa-42abd");
        int result2 = myAtoi("+1");
        System.out.println("result = " + result);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
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
}
