package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 跑步比赛
 */
public class MyService {
    private CyclicBarrier cyclicBarrier;

    public MyService(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
    public  void begin(){
        long sleep= (long) (Math.random()*1000);
        try {
            Thread.sleep(sleep);
            System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+"begin跑步第一阶段"+(cyclicBarrier.getNumberWaiting()+1));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+"end 跑步第一阶段"+cyclicBarrier.getNumberWaiting());
             sleep= (long) (Math.random()*1000);
            Thread.sleep(sleep);
            System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+"begin跑步第二阶段"+(cyclicBarrier.getNumberWaiting()+1));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+"end 跑步第二阶段"+cyclicBarrier.getNumberWaiting());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
