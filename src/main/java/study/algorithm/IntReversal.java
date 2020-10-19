package study.algorithm;

import java.util.regex.Pattern;

/**
 * @author guoyf
 * @params
 * @return
 * @Date 2020/8/25
 */
public class IntReversal {
    public static void main(String[] args) {
//        System.out.println(IntReversal(+250));
//        System.out.println(Solution.reverse(0x7ffffff1));
        System.out.println(Solution.myAtoi("-2147483649"));
    }


    public static int IntReversal(int x) {
        char x_ = '-';
        char xAdd = '+';
        String i = "" + x;
        StringBuilder stringBuilder = new StringBuilder();
        char[] x1 = i.toCharArray();
        if (x1[0] == x_) {
            stringBuilder.append(x_);
        }
        for (int j = x1.length - 1; j > 0; j--) {
            stringBuilder.append(x1[j]);
        }
        if (x1[0] != x_ && x1[0] != xAdd) {
            stringBuilder.append(x1[0]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}

class Solution {
    public static int reverse(int x) {
        String i = "" + x;
        char cut = '-';
        char[] x1 = i.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        if (x1[0] == cut) {
            stringBuilder.append(cut);
        }
        for (int j = x1.length - 1; j > 0; j--) {
            stringBuilder.append(x1[j]);
        }
        if (x1[0] != cut) {
            stringBuilder.append(x1[0]);
        }
        long x2 = Long.parseLong(stringBuilder.toString());
        if (x2 < Integer.MIN_VALUE || x2 > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) x2;
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] s1 = s.toCharArray();
        Pattern pattern = Pattern.compile("[0-9]");
        int index = 0;
        int sign = 1;
        int res = 0;
        if (s1[index] == '-' || s1[index] == '+') {
            sign = (s1[index] == '-' ? -1 : 1);
            index++;
        }
        for (int i = index; i < s1.length; i++) {
            if (!pattern.matcher(s1[i] + "").matches()) {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (s1[i] - '0') > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (s1[i] - '0') > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
            }
                res = res * 10 + sign * (s1[i] - '0');
        }
        return res;
    }
}