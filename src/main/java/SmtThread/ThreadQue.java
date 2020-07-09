package SmtThread;

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
    *  */

    private  static  AtomicBoolean atomicBoolean= new AtomicBoolean(false);
    public static void main(String[] args) throws InterruptedException {
        Q1();
    }
    public static void Q1 () throws InterruptedException {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 正在运行");
            while (!atomicBoolean.get()){
                System.out.println(Thread.currentThread().getName()+" 终止");
            }
        },"1").start();
        Thread.sleep(1000);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 正在运行");
            atomicBoolean.set(true);
            System.out.println("设置 stop 为 true");
        },"2").start();
    }

}
