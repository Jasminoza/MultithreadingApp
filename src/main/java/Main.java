public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable[] runnables = new Runnable[]{
                new Runnable() {
                    public void run() {
                        foo.first(foo);
                    }
                },
                new Runnable() {
                    public void run() {
                        foo.second(foo);
                    }
                },
                new Runnable() {
                    public void run() {
                        foo.third(foo);
                    }
                },
        };

        Thread foo1Thread = new Thread(runnables[0]);
        Thread foo2Thread = new Thread(runnables[1]);
        Thread foo3Thread = new Thread(runnables[2]);
        foo1Thread.start();
        foo1Thread.join();
        foo2Thread.start();
        foo2Thread.join();
        foo3Thread.start();
    }


}
