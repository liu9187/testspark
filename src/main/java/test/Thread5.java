package test;

import java.util.concurrent.Phaser;

public class Thread5 extends Thread {
  private Phaser phaser;

    public Thread5(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        PrintTools.methodA();
    }
}
