package test;

import java.util.concurrent.Phaser;

public class Thread4 extends Thread {
  private Phaser phaser;

    public Thread4(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        PrintTools.methodA();
    }
}
