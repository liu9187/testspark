package test;

import java.util.concurrent.Phaser;

public class Thread6 extends Thread {
  private Phaser phaser;

    public Thread6(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        PrintTools.methodB();
    }
}
