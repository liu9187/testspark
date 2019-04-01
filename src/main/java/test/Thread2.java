package test;

public class Thread2 extends  Thread {
    private MyService2 myService2;

    public Thread2(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
       myService2.testMethod();
    }
}
