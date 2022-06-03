public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        Thread foo1Thread = new Thread(() -> foo.first(foo));
        Thread foo2Thread = new Thread(() -> foo.second(foo));
        Thread foo3Thread = new Thread(() -> foo.third(foo));
        foo1Thread.start();
        foo1Thread.join();
        foo2Thread.start();
        foo2Thread.join();
        foo3Thread.start();
    }


}
