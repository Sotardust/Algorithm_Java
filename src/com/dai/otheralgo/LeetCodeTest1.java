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
        System.out.println("result = " + 10 * 8);
        System.out.println("result = " + (10 ^ 3));
        System.out.println("result = " + (10 ^ 2));
        System.out.println("result = " + (1994 / 1000));

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        maxArea(height);
        intToRoman(1994);
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
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 说明:
     * <p>
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * <p>
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {


        return true;
    }

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     * <p>
     * <p>
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int value = (right - left) * (height[left] > height[right] ? height[right--] : height[left++]);
            if (value > maxArea) {
                maxArea = value;
            }
            System.out.println("value = " + value + "maxArea = " + maxArea);
        }
        return maxArea;
    }

    /**
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
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
     * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 3
     * 输出: "III"
     * 示例 2:
     * <p>
     * 输入: 4
     * 输出: "IV"
     * 示例 3:
     * <p>
     * 输入: 9
     * 输出: "IX"
     * 示例 4:
     * <p>
     * 输入: 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        return builder.toString();
    }

    public static int getResult(long num) {

        int sum = 1;
        while (num != 0) {
            sum = sum * 10;
            num--;
        }
        return sum;
    }
}
