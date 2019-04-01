package test;

import java.util.concurrent.CountDownLatch;

public class MyThread1 extends Thread {
    private CountDownLatch maxRuner;

    public MyThread1(CountDownLatch maxRuner) {
        this.maxRuner = maxRuner;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        maxRuner.countDown();
    }
}
