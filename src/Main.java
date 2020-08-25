

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

import static com.dai.TestKt.test;

public class Main {

    public static void main(String[] args) {

        test();
//
//        String value = "{\"beans\":[{\"IDCard\":\"152485698547852365\",\"c_addTime\":\"2020-03-21 16:01:53\",\"c_status\":0,\"c_value\":\"32.9\"}]}";
//
//
//        HashMap<String,String> hashMap = new HashMap<>(16);
//        hashMap.put("fdas","fda");
//
//        Test test = new Test();
//
////        test.testSingleLinkedList();
//
////        System.out.println("getStartDate(1) = " + getStartDate(1));
////        System.out.println("getStartDate(7) = " + getStartDate(31));
//
////        test.testMaxSum();
//
////        test.testBiSearch();
//
////        test.testSort();
//
//        int x = 2, y = 1;
//        //x = 0000 0010
//        //y = 0000 0001
//        //^ = 0000 0011;
//
////        x = x^y;
////        y = x^y;  //y=(x^y)^y
////        x = x^y;  //x=(x^y)^
//
////        System.out.println("x^y = " + (x ^ y));
////        System.out.println("x^y = " + ((x ^ y) ^ x));
////        System.out.println("x^y = " + ((x ^ y) ^ y));
////
////        String a = "123";
////        String b = "123";
////        String d = a + "a";
////        String e = "123" + "a";
////        System.out.println("main() called with: args = [" + (a == b) + "]");
////        System.out.println("main() called with: args = [" + (d == e) + "]");
//
//        byte[] data = {-69, 0, 13, -95, -16, 1, -12, 0, 0, 0, 7, 0, 28, 60, 100, -25};
////        for (byte data: datas){
////            System.out.print((data & 0xff)+" ,");
////        }
////        getTempers(datas) ;
//        byte dataH = data[5];
//        byte dataL = data[6];
//        int sensTmp = (dataH & 0xff) * 256 + (dataL & 0xff);
//        float sens = get2Accuracy(((float) sensTmp / 100));
//        float acc = get2Accuracy((float) toUnsignedShortHigh(data, 7) / 10);
//        float v = get2Accuracy((float) toUnsignedShortHigh(data, 9) / 10);
//        float s = get2Accuracy((float) toUnsignedShortHigh(data, 11));
//        float temper = get2Accuracy((float) (toUnsignedShortHigh(data, 13) * 0.02 - 273.15));
//        System.out.println("sens = " + sens);
//        System.out.println("acc = " + acc);
//        System.out.println("v = " + v);
//        System.out.println("s = " + s);
//        System.out.println("temper = " + temper);

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

    public static double[] getTempers(byte[] b) {
        double[] temper = new double[3];//三个温度 最小 当前 最大
        if (b[4] == 0x00) {//获取成功
            temper[0] = (b[5] & 0xff) * 256 + (b[6] & 0xff);
            temper[0] = (temper[0] - 1000) / 10;

            temper[1] = (b[7] & 0xff) * 256 + (b[8] & 0xff);
            temper[1] = (temper[1] - 1000) / 10;

            temper[2] = (b[9] & 0xff) * 256 + (b[10] & 0xff);
            temper[2] = (temper[2] - 1000) / 10;
        } else {
            return null;
        }
        return temper;
    }

    public static float get2Accuracy(float d) {
        DecimalFormat df = new DecimalFormat("######0.00");
        String abs = df.format(d);
        d = Float.parseFloat(abs);
        return d;
    }

    public static short toUnsignedShortHigh(byte[] data, int start) {
        return (short) (((short) (data[start] & 0xff) << 8) | (short) (data[start + 1] & 0xff));
    }
}
