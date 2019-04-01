package test;

public class MyThread3 extends  Thread {
    private MyService1 myService1;

    public MyThread3(MyService1 myService1) {
        this.myService1 = myService1;
    }

    @Override
    public void run() {
        myService1.test();
    }
}
