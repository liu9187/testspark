package test;

import java.util.concurrent.Exchanger;

public class ThreadA extends Thread {
    private Exchanger<String> exchanger;

    public ThreadA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程A中得到线程B的值="+exchanger.exchange("中国人A"));
            System.out.println("A end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger=new Exchanger<>();
           ThreadA a=new ThreadA(exchanger);
           a.start();
        System.out.println("main end");
    }
}
