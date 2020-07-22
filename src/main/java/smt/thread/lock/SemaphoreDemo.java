package smt.thread.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private Semaphore semaphore = new Semaphore(2);
    private String resources = "我是这个资源";
    private String getResources(){
        try {
            semaphore.acquire();
            try {
                // 模拟业务
                System.out.println(Thread.currentThread()+"正在尝试获取资源");
                Thread.sleep(2000);
                return resources;
            }catch (Exception e){

            }finally {
                // 释放许可
                semaphore.release();
            }
        }catch (InterruptedException i){
            System.out.println("被中断了");
        }
        return "";
    }

    public static void main(String[] args) {
        SemaphoreDemo s = new SemaphoreDemo();
        new Thread(()->{
            System.out.println(s.getResources());
        },"t1").start();
        new Thread(()->{
            System.out.println(s.getResources());
        },"t2").start();
        new Thread(()->{
            System.out.println(s.getResources());
        },"t3").start();
    }
}
