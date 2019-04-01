package test;

public class Thread3 extends  Thread {
    private MyService2 myService2;

    public Thread3(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
       myService2.testMethod();
    }
}
