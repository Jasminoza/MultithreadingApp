package Foo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        System.out.println("Zapusk potokov.");

        new MyThread2(cb, "A").start();
        new MyThread2(cb, "B").start();
        new MyThread2(cb, "C").start();
        new MyThread2(cb, "X").start();
        new MyThread2(cb, "Y").start();
        new MyThread2(cb, "Z").start();
    }
}

class MyThread2 extends Thread implements Runnable {
    CyclicBarrier cbar;
    String name;

    MyThread2(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Baryer dostignut!");
    }
}

