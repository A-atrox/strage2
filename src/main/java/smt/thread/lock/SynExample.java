package smt.thread.lock;

public class SynExample {// synchronized demo
    private static int tickets = 10;
    private static String monitor = "demo1";
    private static volatile int t2 = 0;

    private static void demo1() {
        synchronized (monitor) {
            if (tickets > 0) {
                tickets--;
                System.out.println(Thread.currentThread() + "做了1次减操作");
            }
        }
    }

    private static synchronized void demo2() {
        System.out.println(Thread.currentThread() + "剑尖t2");
        if (t2 < 15) {
            t2++;
        }

    }

    public synchronized void demo3() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() +"  "+ i);
            }
    }

    public static void main(String[] args) throws InterruptedException {
        // 1.修饰在方法里面的一个语句块时
//        System.out.println(tickets);
//        new Thread(()->{
//            while(tickets>0){
//                SynExample.demo1();
//            }
//
//        },"t1").start();
//        new Thread(()->{
//            while(tickets>0){
//                SynExample.demo1();
//            }
//        },"t2").start();
//        Thread.sleep(1000);
//        System.out.println(tickets);

        // 2.当修饰的是static方法时属于这个CLASS的锁
//        System.out.println(t2);
//        new Thread(() -> {
//            while (t2 < 15) {
//                SynExample.demo2();
//            }
//
//        }, "t3").start();
//        new Thread(() -> {
//            while (t2 < 15) {
//                SynExample.demo2();
//            }
//        }, "t4").start();
//        Thread.sleep(1000);
//        System.out.println(t2);

        // 当修饰的时普通方法时
        SynExample s1 = new SynExample();
        new Thread(()->{
            s1.demo3();
        },"t4").start();
        new Thread(()->{
            s1.demo3();
        },"t5").start();
    }
}
