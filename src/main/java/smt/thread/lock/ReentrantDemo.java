package smt.thread.lock;

import study.lang.BoxClass.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo {
    private static Lock lock2 = new ReentrantLock();
    //Lock lock=new ReentrantLock(true);  //公平锁
    //Lock lock=new ReentrantLock(false); //非公平锁
    //创建Condition
    private Condition conditionA = lock2.newCondition();

    private final Lock lock = new ReentrantLock(false);
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s){
        lock.lock();
        try {
            queue.add(s);
            System.out.println("已经新增了数据，正在唤醒");
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
    public String getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("我正在等待");
                condition.await();
            }
            return queue.remove();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void testMethod1() {
        lock2.lock();
        try {
            //lock加锁
            //1：wait 方法等待：
            System.out.println(Thread.currentThread() + " " + "开始wait");
            // await 的作用是能够让其他线程访问竞争资源，所以挂起状态就是要释放竞争资源的锁
            conditionA.await(1000, TimeUnit.SECONDS);// 等三秒无人唤醒自己醒过来
            //通过创建Condition对象来使线程wait，必须先执行lock.lock方法获得锁

            // 通过signal唤醒
//            conditionA.signal();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args){
        ReentrantDemo r1 = new ReentrantDemo();
        new Thread(()->{
            System.out.println(r1.getTask());
        }).start();
        new Thread(()->{
            r1.addTask("第一个任务");
        }).start();

    }
}