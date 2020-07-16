package smt.thread;

import java.util.concurrent.*;

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
//        new Thread(s1,"小王").start();
//        new Thread(s2,"小张").start();
//        System.out.println("线程结束");
//        System.out.println("开始倒计时");
//        new SimpleThread().start();
        ExecutorService service = Executors.newCachedThreadPool();
        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        SimpleCallable task = new SimpleCallable();
        //1.第一种实现方式
//        Future<Integer> future = service.submit(task);
//        try {
//            System.out.println(future.get(1500,TimeUnit.MILLISECONDS));
//            service.shutdown();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // 第二种实现方式,高并发下可以保证任务只被执行一次
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        //FutureTask能够在⾼并发环境下确保任务只执⾏⼀次
        service.submit(futureTask);
        try {
            System.out.println(futureTask.get(1500,TimeUnit.MILLISECONDS));
            service.shutdown();//关闭线程池。与使用数据库连接池一样，每次使用完毕后，都要关闭线程池
            // 停止接收新任务，原来的任务继续执行
            //shutdown()：停止接收新任务，原来的任务继续执行
            // shutdownNow()：停止接收新任务，原来的任务停止执行
            //awaitTermination(long timeOut, TimeUnit unit)：当前线程阻塞
            //awaitTermination时，主线程会处于一种等待的状态，等待线程池中所有的线程都运行完毕后才继续运行。
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
class SimpleCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }
}

