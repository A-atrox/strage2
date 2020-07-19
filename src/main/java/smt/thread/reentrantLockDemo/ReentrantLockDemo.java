package smt.thread.reentrantLockDemo;

public class ReentrantLockDemo extends LockFather {// 可重入锁
    private boolean isLocked = false;
    private Thread localBy = null;
    private int lockedCount = 0;
    @Override
    public synchronized void lock() {
        Thread thread = Thread.currentThread();
        while (isLocked && localBy != thread) {
            try {
                System.out.println("正在尝试获取锁");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("获取锁成功");
        isLocked = true;
        lockedCount++;
        localBy = thread;
    }

    @Override
    public synchronized void unLock() {
        if (Thread.currentThread() == this.localBy) {
            lockedCount--;
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }

}
