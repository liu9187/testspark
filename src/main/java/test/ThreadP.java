package test;

/**
 * 生产者
 */
public class ThreadP extends Thread {
     private  RepastService repastService;

    public ThreadP(RepastService repastService) {
        super();
        this.repastService = repastService;
    }

    @Override
    public void run() {
         repastService.set();
    }
}
