package smt.thread.reentrantLockDemo;

public class LockFather {
    public void lock(){
        System.out.println("这是上锁");
    };
    public void unLock(){
        System.out.println("这是解锁");
    };
}
