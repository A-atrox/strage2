package smt.thread.stopthread;

/**
 * @author guoyf
 * @创建时间 2020/7/10
 * @描述
 */
public class TestSystemMonitor {
    public static void main(String[] args) {
        testSystemMonitor();
    }

    public static void testSystemMonitor() {
        SystemMonitor sm = new SystemMonitor();
        sm.start();
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("监控任务启动 10 秒后，停止");
        sm.stop();
    }
}
