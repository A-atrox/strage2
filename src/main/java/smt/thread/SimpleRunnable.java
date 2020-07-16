package smt.thread;

/**
 * @author guoyf
 * @创建时间 2020/6/24
 * @描述
 */
public class SimpleRunnable implements Runnable {

    private  static int tickets = 10;

    @Override
    public void run() {
        while(tickets>0){
            sellTickets();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void sellTickets() {
        synchronized (SimpleThread.class) {
            if (tickets > 0) {
                tickets--;
                System.out.println(Thread.currentThread().getName() + "卖出第:" + (10 - tickets) + "张票"+"还剩下"+tickets+"张");
            }
        }

    }
}
