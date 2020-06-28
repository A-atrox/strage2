package SmtThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author guoyf
 * @创建时间 2020/6/24
 * @描述
 */
public class SimpleThread extends Thread {

    private long mills = 10000L;
    private int times = 10;
    Date endDate = new Date(System.currentTimeMillis() + mills);
    long endTime = endDate.getTime();

    @Override
    public void run() {
        while (true) {
            System.out.println("倒计时"+times+"s");
            endDate = new Date(endDate.getTime() - 1000);
            times--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (endTime - endDate.getTime() > mills) {
                break;
            }
        }

    }

}
