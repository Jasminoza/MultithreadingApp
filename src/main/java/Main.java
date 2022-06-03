public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable[] runnables = new Runnable[]{
                () -> foo.first(foo),
                () -> foo.second(foo),
                () -> foo.third(foo),
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
