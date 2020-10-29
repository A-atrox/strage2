package study.algorithm;

/**
 * @author guoyf
 * @Date 2020/10/21
 */
public class VampireNumber {
    public static void main(String[] args) {
        for (int i = 1001; i < 9999; i++) {
            int a = i / 1000;
            int b = (i / 100) % 10;
            int c = (i / 10) % 10;
            int d = i % 10;
            int sum = b + c + d;
            if (sum == b || sum == c || sum == d) {
                continue;
            }
            isVampire(a, b, c, d, i);
        }
    }

    /**
     * 输入一个数num 和已经提取出来的 ab
     */
    public static int com(int m, int n) {
        int mn = m * 10 + n;
        return mn;
    }

    public static boolean valid(int ab, int ba, int cd, int dc, int num) {
        if (ab * cd == num || ab * dc == num || ba * cd == num || ba * dc == num) {
            return true;
        }
        return false;
    }

    public static void isVampire(int a, int b, int c, int d, int num) {

        int ab = com(a, b);
        int ba = com(b, a);
        int cd = com(c, d);
        int dc = com(d, c);

        int ac = com(a, c);
        int ca = com(c, a);
        int bd = com(b, d);
        int db = com(d, b);

        int ad = com(a, d);
        int da = com(d, a);
        int bc = com(b, c);
        int cb = com(c, b);
        if (valid(ab, ba, cd, dc, num) || valid(ac, ca, bd, db, num) || valid(ad, da, bc, cb, num)) {
            System.out.println(num);
        }

    }
}
