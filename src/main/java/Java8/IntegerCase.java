package Java8;

/**
 * @author guoyf
 * @Date 2020/9/4
 * @describe
 */
public class IntegerCase {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 1000;
        Integer d = 1000;
        Integer e = -1000;
        Integer f = -1000;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == f);

        /***
         * 唯一的区别是，System.getProperty只能获取非内部的配置信息
         */
        String a1 = sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        String b1 = sun.misc.VM.getSavedProperty("high");
        String c1 = System.getProperty("java.lang.Integer.IntegerCache.high");
        String d1 = System.getProperty("high");
        System.err.println(a1);
        System.err.println(b1);
        System.err.println(c1);
        System.err.println(d1);
    }
}
