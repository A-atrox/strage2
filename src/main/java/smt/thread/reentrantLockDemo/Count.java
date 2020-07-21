package smt.thread.reentrantLockDemo;

public class Count {
    LockFather lock = null;

    public Count() {
    }

    public Count(LockFather lockFather) {
        this.lock = lockFather;
    }

    public void print() throws InterruptedException {
        lock.lock();
        doAdd();
        lock.unLock();
    }

    public void doAdd() throws InterruptedException {
        lock.lock();
        System.out.println("工作");
        lock.unLock();
    }

}
