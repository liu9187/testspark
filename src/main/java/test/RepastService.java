package test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试生产者消费者模式
 */
public class RepastService {
    //厨师
    volatile  private Semaphore setSemaphore=new Semaphore(10);
    //就餐者
    volatile  private Semaphore getSetSemaphore=new Semaphore(20);
    volatile  private ReentrantLock lock=new ReentrantLock();
    volatile private Condition setCondition=lock.newCondition();
    volatile  private Condition getSetCondition=lock.newCondition();
    //最多只有4个盒子存放菜
    volatile  private Object[] producePostion=new Object[4];
    private  boolean isEmpty(){
        boolean isEmpty=true;
        for (int i=0;i<producePostion.length;i++) {
            if (producePostion[i] != null) {
                isEmpty = false;
                break;
            }
        }
         return  isEmpty;
        }

    private boolean isFull(){
        boolean isFull=true;
        for (int i=0;i<producePostion.length;i++){
              if (producePostion[i]==null){
                  isFull=false;
                  break;
              }
        }
        return  isFull;
    }

    public void  set(){
       // System.out.println("-------set------");
        try {
              //允许最多有十个厨子生产
             setSemaphore.acquire();
             lock.lock();
             while (isFull()){
                 System.out.println("----生产者在等待----");
                 setCondition.await();
             }
             //
            for (int i=0;producePostion.length>0;i++){
                 if (producePostion[i]==null){
                     producePostion[i]="数据";
                     System.out.println(Thread.currentThread().getName()+"生产了"+producePostion[i]);
                     break;
                 }
            }

            getSetCondition.signalAll();
             lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            setSemaphore.release();
        }
    }
    public  void  get(){
     //   System.out.println("------get----");
        try {
            getSetSemaphore.acquire();
            lock.lock();
            while (isEmpty()){
                System.out.println("-----消费者在等待------");
                 getSetCondition.await();
            }
            for (int i=0;i<producePostion.length;i++){
                 if (producePostion[i]!=null){
                     System.out.println(Thread.currentThread().getName()+"消费了"+producePostion[i]);
                     producePostion[i]=null;
                     break;
                 }
            }
            setCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            getSetSemaphore.release();
        }
    }
}
