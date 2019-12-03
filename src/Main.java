import com.dai.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {


        Test test = new Test();

        test.testSingleLinkedList();

//        System.out.println("getStartDate(1) = " + getStartDate(1));
//        System.out.println("getStartDate(7) = " + getStartDate(31));

//        test.testMaxSum();

//        test.testBiSearch();

//        test.testSort();

        int x = 2, y = 1;
        //x = 0000 0010
        //y = 0000 0001
        //^ = 0000 0011;

//        x = x^y;
//        y = x^y;  //y=(x^y)^y
//        x = x^y;  //x=(x^y)^

//        System.out.println("x^y = " + (x ^ y));
//        System.out.println("x^y = " + ((x ^ y) ^ x));
//        System.out.println("x^y = " + ((x ^ y) ^ y));
//
//        String a = "123";
//        String b = "123";
//        String d = a + "a";
//        String e = "123" + "a";
//        System.out.println("main() called with: args = [" + (a == b) + "]");
//        System.out.println("main() called with: args = [" + (d == e) + "]");

    }
    /**
     * 根据当前时间日期获取前几天日期
     *
     * @param day 天数
     * @return 开始日期
     */
    private static String getStartDate(int day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        long result = System.currentTimeMillis() - (long) (day - 1) * 24 * 60 * 60 * 1000;
        return format.format(result);
    }
}
