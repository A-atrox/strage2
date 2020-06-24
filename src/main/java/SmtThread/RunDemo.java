package SmtThread;

/**
 * @author guoyf
 * @创建时间 2020/6/24
 * @描述
 */
public class RunDemo {
    public static void main(String[] args) {
//        System.out.println("多线程创建");
//        SimpleRunnable s1 = new SimpleRunnable();
//        SimpleRunnable s2 = new SimpleRunnable();
//        System.out.println("线程启动");
//        new Thread(s1).start();
//        new Thread(s2 ).start();
//        System.out.println("线程结束");
        System.out.println("开始倒计时");
        new SimpleThread().start();
    }

}

