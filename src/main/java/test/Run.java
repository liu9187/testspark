package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;

public class Run {
    public static void main(String[] args) throws InterruptedException {
//        ListPool listPool=new ListPool();
//        MyThread[] myThreads=new MyThread[12];
//          for (int i=0;i<myThreads.length;i++){
//              myThreads[i]=new MyThread(listPool);
//          }
//          for (int i=0;i<myThreads.length;i++){
//              myThreads[i].start();
//          }

//        RepastService service=new RepastService();
//        ThreadP[] p=new ThreadP[60];
//        ThreadC[] c=new ThreadC[60];
//        for (int i=0;i<60;i++){
//            p[i]=new ThreadP(service);
//            c[i]=new ThreadC(service);
//        }
//        Thread.sleep(2000);
//        for (int i=0;i<60;i++){
//              p[i].start();
//              c[i].start();
//        }

//        Exchanger<String> exchanger=new Exchanger<>();
//        ThreadA a=new ThreadA(exchanger);
//        ThreadB b=new ThreadB(exchanger);
//        a.start();
//        b.start();

//        CountDownLatch maxRuner=new CountDownLatch(10);
//         MyThread1[] threads=new MyThread1[Integer.parseInt(maxRuner.getCount()+"")];
//         for (int i=0;i<threads.length;i++){
//             threads[i] =new MyThread1(maxRuner);
//             threads[i].setName("线程"+(i+1));
//             threads[i].start();
//         }
//        maxRuner.await();
//        System.out.println("都回来了");

        //实现所有线程都到达同步点在继续运行的效果
        CyclicBarrier cyclicBarrier=new CyclicBarrier(2, () -> System.out.println("全都到了"));

                MyThread2[] myThreads=new MyThread2[4];
          for (int i=0;i<myThreads.length;i++){
              myThreads[i]=new MyThread2(cyclicBarrier);
          }
          for (int i=0;i<myThreads.length;i++){
              myThreads[i].start();
            //  Thread.sleep(2000);
          }

    }
}
