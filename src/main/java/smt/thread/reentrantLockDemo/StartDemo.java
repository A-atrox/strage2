package smt.thread.reentrantLockDemo;

public class StartDemo {
    public static void main(String[] args) throws Exception{
        // 不可重入demo示例
        // 当前线程执行print()方法首先获取lock，接下来执行doAdd()方法就无法执行doAdd()中的逻辑，必须先释放锁。这个例子很好的说明了不可重入锁。
//        Count count1 = new Count(new Lock());
//        count1.print();
        // 可重入demo示例
        // 所谓可重入，意味着线程可以进入它已经拥有的锁的同步代码块儿。
        Count count2 = new Count(new ReentrantLockDemo());
        count2.print();
}
}
