package com.zl.thread;

/**
 * @author zl
 * @descrption 线程
 * @time 2017.05.02
 */
class MyThread implements Runnable {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + "运行 : "+i);
        }
    }
}

public class MyThreadTest {
    public static void main(String[] args) {
        new Thread(new MyThread("Thread3")).start();
        new Thread(new MyThread("Thread4")).start();
    }
}
