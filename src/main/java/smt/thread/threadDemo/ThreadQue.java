package smt.thread.threadDemo;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author guoyf
 * @创建时间 2020/7/9
 * @描述
 */
public class ThreadQue {
    /*
     * 1.CPU 缓存，在多核 CPU 的情况下，带来了可见性问题
     * 2.操作系统对当前执行线程的切换，带来了原子性问题
     * 3.编译器指令重排优化，带来了有序性问题
     * java编译器和处理器不会对存在   数据依赖关系   的操作做重排序，因为这种重排序会改变执行结果。
     *  */
    /**
     * atomicBoolean：测试可见性变量
     **/
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private static boolean stop = false;
    /**
     * count：测试原子性变量
     **/
    static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
//        1.CPU 缓存，在多核 CPU 的情况下，带来了可见性问题,
//        可以通过 volatile、synchronized、Lock接口、Atomic 类型保障可见性。
//        new Thread(() -> {
//            System.out.println("线程 1 正在运行...");
//            while (!stop) {
//                System.out.println("线程 1 终止");
//            }
//        }).start();
//        Thread.sleep(100);
//        //启动线程 2， 设置 stop = true
//        new Thread(() -> {
//            System.out.println("线程 2 正在运行...");
//            stop = true;
//            System.out.println("设置 stop 变量为 true.");
//        }).start();
//        Q1Resolve();
//        2.操作系统对当前执行线程的切换，带来了原子性问题
//        Q2();
//        Q2Resolve();

    }

    public static void Q1Resolve() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 正在运行");
            while (!atomicBoolean.get()) {
                System.out.println(Thread.currentThread().getName() + " 终止");
            }
        }, "1");
        thread1.start();
        Thread.sleep(10);
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 正在运行");
            atomicBoolean.set(true);
            System.out.println("设置 stop 为 true");
        }, "2");
        thread2.start();
    }

    public static void Q2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                count++;
            }
            System.out.println("thread t1 count 加 10000 结束");
        });

        //线程 2 给 count 加 10000
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                count++;
            }
            System.out.println("thread t2 count 加 10000 结束");
        });

        //启动线程 1
        t1.start();
        //启动线程 2
        t2.start();

        //等待线程 1 执行完成
        t1.join();
        //等待线程 2 执行完成
        t2.join();

        //打印 count 变量
        System.out.println(count);
    }

    public static void Q2Resolve() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                addCount();
            }
            System.out.println("thread t1 count 加 10000 结束");
        });

        //线程 2 给 count 加 10000
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                addCount();
            }
            System.out.println("thread t2 count 加 10000 结束");
        });

        //启动线程 1
        t1.start();
        //启动线程 2
        t2.start();

        //等待线程 1 执行完成
        t1.join();
        //等待线程 2 执行完成
        t2.join();

        //打印 count 变量
        System.out.println(count);
    }

    private synchronized static void addCount() {
        count++;
    }
}
