package study.algorithm;

/**
 * @author guoyf
 * @Date 2020/7/30
 * @describe
 */
public class DemoTest {
    public static void main(String[] args) {
//        QueueDemo<Integer> q1 = new QueueDemo<>();

        //先进
//        for (int i = 0; i < 10; i++) {
//            q1.push(i);
//        }
//        System.out.println(q1.getSize());
        //先出
//        for (int i = 0; i <10 ; i++) {
//            System.out.println(q1.pop());
//        }
        StackDemo<Integer> s1 = new StackDemo<>();
        // 先进
        int size = 10;
        for (int i = 0; i < size; i++) {
            s1.push(i);
        }
        System.out.println(s1.getSize());
        // 后出
        for (int i = 0; i < 10; i++) {
            System.out.println(s1.pop());
        }
    }
}
