package smt.thread.reentrantLockDemo;

public class Lock extends LockFather{
    private boolean isLocked = false;
    @Override
    public synchronized void lock()  {
        while (isLocked){
            System.out.println("正在尝试获取锁");
            try {
                wait();// 不可重入锁 这里会卡死 InterruptedException
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("获取锁成功");
        isLocked = true;
    }
    @Override
    public synchronized void unLock(){
        isLocked = false;
        notify();
    }

}
