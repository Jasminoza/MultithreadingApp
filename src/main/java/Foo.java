public class Foo {
    public MyThread a;
    public MyThread b;
    public MyThread c;

    public static void first(Runnable r) {
        System.out.print("first");
    }

    public static void second(Runnable r) {
        System.out.print("second");
    }

    public static void third(Runnable r) {
        System.out.print("third");
    }

    Foo() throws InterruptedException {
        a = new MyThread("A");
        b = new MyThread("B");
        c = new MyThread("C");
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
    }
}

class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (currentThread().getName().equals("A")) Foo.first(this);
        if (currentThread().getName().equals("B")) Foo.second(this);
        if (currentThread().getName().equals("C")) Foo.third(this);
    }
}