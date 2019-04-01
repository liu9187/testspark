package test;

import java.nio.ByteBuffer;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Test {
    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
//        MyService myService=new MyService(cyclicBarrier);
//        Thread1 thread11=new Thread1(myService);
//          thread11.setName("A");
//          thread11.start();
//        Thread1 thread12=new Thread1(myService);
//        thread12.setName("B");
//        thread12.start();
//        Thread1 thread13=new Thread1(myService);
//        thread13.setName("C");
//        thread13.start();
//
//        Thread1 thread14=new Thread1(myService);
//        thread14.setName("D");
//        thread14.start();

        //istoken验证
//        int parties=4;
//        CyclicBarrier cyclicBarrier=new CyclicBarrier(parties,()-> System.out.println("都到了"));
//        MyService1 myService1=new MyService1(cyclicBarrier);
//        MyThread3[] myThread3s=new MyThread3[4];
//         for (int i=0;i<myThread3s.length;i++){
//             myThread3s[i]=new MyThread3(myService1);
//             myThread3s[i].start();
//         }

        //Phaser 验证
//        Phaser phaser=new Phaser(3);
//        PrintTools.phaser=phaser;
//        Thread4 thread4=new Thread4(phaser);
//        thread4.setName("A");
//        thread4.start();
//        Thread5 thread5=new Thread5(phaser);
//        thread5.setName("B");
//        thread5.start();
//        Thread6 thread6=new Thread6(phaser);
//        thread6.setName("C");
//        thread6.start();

//        Phaser phaser=new Phaser(2){
//            @Override
//            protected boolean onAdvance(int phase, int registeredParties) {
//                System.out.println("-----时间呗调用了");
//                return  false;
//            }
//        };
//        MyService2 service2=new MyService2(phaser);
//        Thread2 thread2=new Thread2(service2);
//        thread2.setName("A");
//        thread2.start();
//        Thread3 thread3=new Thread3(service2);
//        thread3.setName("B");
//        thread3.start();


//        byte[] bytes=new byte[]{1,2,3};
//         ByteBuffer byteBuffer= ByteBuffer.wrap(bytes);
//        System.out.println(byteBuffer.getClass().getName());
        MyThreadFactory myThreadFactory=new MyThreadFactory();
        ExecutorService executorService=Executors.newFixedThreadPool(2,myThreadFactory);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("begin 我在运行 "+System.currentTimeMillis()+"  "+Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end 我在运行 "+System.currentTimeMillis()+"  "+Thread.currentThread().getName());
            }
        };
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
    }
}
