package study.algorithm;

/**
 * @author guoyf
 * @Date 2020/8/7
 * @describe
 */
public class CubeRoot {
    private static double degree = 0.00001;
    public static void main(String[] args) {
        System.out.println(computer(27));
    }
    public static double computer(int num){
        double x = 1;
        double x1 = 2*x/3 + num/(3*x*x);
        while(Math.abs(x1-x)>degree){
            x = x1;
            x1 = 2*x/3 + num/(3*x*x);
        }
        return x1;
    }
}
