package test;

import java.util.concurrent.Exchanger;

public class ThreadB extends  Thread {
     private Exchanger<String> exchanger;

    public ThreadB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程B中获取线程A中的值="+exchanger.exchange("中国人B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
