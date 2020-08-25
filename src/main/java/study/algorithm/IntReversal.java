package study.algorithm;

/**
 *@params
 *@return
 *@author  guoyf
 *@Date  2020/8/25
 */
public class IntReversal {
    public static void main(String[] args) {
        System.out.println(IntReversal(+250));
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
        if (x1[0] != x_ && x1[0]!=xAdd) {
            stringBuilder.append(x1[0]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
