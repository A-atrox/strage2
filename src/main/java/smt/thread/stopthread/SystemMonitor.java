package smt.thread.stopthread;

/**
 * 系统监控器
 *
 * @author guoyf
 * @创建时间 2020/7/10
 * @描述
 */
public class SystemMonitor {
    private Thread thread;
    private volatile boolean stop = false;
    public void start() {
        thread = new Thread(() -> {
            while (!stop) {
                System.out.println("正在监控系统...");
                try {
                    Thread.sleep(3000);
                    System.out.println("线程执行3秒");
                    System.out.println("监控系统正常");
                } catch (InterruptedException e) {
                    System.out.println("任务执行被中断...");
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    void stop() {
        thread.interrupt();
        stop = true;
    }
}
