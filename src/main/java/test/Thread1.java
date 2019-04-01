package test;

public class Thread1  extends Thread{
    private MyService myService;

    public Thread1(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.begin();
    }
}
