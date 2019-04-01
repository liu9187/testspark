package test;

import java.util.concurrent.Phaser;

public class MyService2 {
    private Phaser phaser;

    public MyService2(Phaser phaser) {
        this.phaser = phaser;
    }
    public void testMethod(){
            try {
                System.out.println("A begin  Thread name ="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
                if (Thread.currentThread().getName().equals("B")){
                    Thread.sleep(5000);
                }

                phaser.arriveAndAwaitAdvance();
                System.out.println("A end  Thread name ="+Thread.currentThread().getName()+"end phaser value="+phaser.getPhase()+
                " "+System.currentTimeMillis());
               ///
                System.out.println("B begin  Thread name ="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
                if (Thread.currentThread().getName().equals("B")){
                    Thread.sleep(5000);
                }

                phaser.arriveAndAwaitAdvance();
                System.out.println("B end  Thread name ="+Thread.currentThread().getName()+"end phaser value="+phaser.getPhase()+
                        " "+System.currentTimeMillis());
              ///
                System.out.println("C begin  Thread name ="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
                if (Thread.currentThread().getName().equals("B")){
                    Thread.sleep(5000);
                }

                phaser.arriveAndAwaitAdvance();
                System.out.println("C end  Thread name ="+Thread.currentThread().getName()+"end phaser value="+phaser.getPhase()+
                        " "+System.currentTimeMillis());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
