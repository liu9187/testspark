package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService1 {
    private CyclicBarrier cyclicBarrier;

    public MyService1(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
    private void  begin(int count){
            try {
                System.out.println(Thread.currentThread().getName()+"到了 在等待其他人都到了再开始跑");
                if (Thread.currentThread().getName().equals("Thread-2")){
                    System.out.println("thread-2 进来了");
                Thread.sleep(5000);
                //Integer.parseInt("a");
                    Thread.currentThread().interrupt();
                }
                cyclicBarrier.await();
                System.out.println("都到了开始跑");
                System.out.println(Thread.currentThread().getName()+"到达终点并结束第"+count+"赛段");
            } catch (InterruptedException e) {
                System.out.println("进入 InterruptedException"+cyclicBarrier.isBroken());
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println("进入 BrokenBarrierException"+cyclicBarrier.isBroken());
                e.printStackTrace();
            }

    }
    public  void  test(){
        for (int i=0;i<1;i++){
            begin(i+1);
        }
    }
}
