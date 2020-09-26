package com.base.thread.start;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程启动的方式
 * @Author: kim
 * @Date: 2020/5/24 19:08
 * @Version: 1.0
 */
public class CreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()-> {
            System.out.println("Hello Lambda!");
        }).start();

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("Hello ThreadPool");
        });
        service.shutdown();

    }
}
