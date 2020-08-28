package Java8;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author guoyf
 * @Date 2020/8/28
 * @describe
 */
public class LambdaTest {
    private static Map<String, String> map = new HashMap() {{
        put("a", "a");
        put("b", "b");
        put("c", "c");
        put("d", "d");
    }};
    private static List<String> list = new ArrayList() {{
        add("a");
        add("bb");
        add("ccc");
        add("dddd");
    }};
    public static void main(String[] args) throws InterruptedException {
        // 普通方式遍历
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("k=" + entry.getKey() + ",v=" + entry.getValue());
        }
        for (String s : list) {
            System.out.println(s);
        }
        // Lambda进行遍历map
        map.forEach((k, v) -> System.out.println("k=" + k + ",v=" + v));
        // list拉姆达表达式遍历
        list.forEach(v -> System.out.println(v));
        //list双冒号运算符遍历
        list.forEach(System.out::println);

        threadDemo();


    }
    private static void threadDemo() throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"普通方式创建");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r2 = () -> {
            System.out.println("lambda方式创建");
            System.out.println(new Date());
        };

        ScheduledThreadPoolExecutor service =
                new ScheduledThreadPoolExecutor(3,new BasicThreadFactory.Builder().namingPattern("example--").daemon(false).build(),new ThreadPoolExecutor.CallerRunsPolicy());
        service.execute(r1);
        service.execute(r2);
        System.out.println("开始等待");
        service.shutdown();
        boolean b = service.awaitTermination(3, TimeUnit.SECONDS);
        if(b){
            System.out.println("分线程已经运行结束");
        }
        service.shutdown();
    }
}
