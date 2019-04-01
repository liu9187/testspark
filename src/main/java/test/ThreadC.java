package test;

/**
 * 消费者
 */
public class ThreadC extends Thread {
    private RepastService repastService;

    public ThreadC(RepastService repastService) {
        super();
        this.repastService = repastService;
    }

    @Override
    public void run() {
         repastService.get();
    }
}
