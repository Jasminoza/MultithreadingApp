public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(() -> foo.second(Thread.currentThread())).start();
        new Thread(() -> foo.third(Thread.currentThread())).start();
        new Thread(() -> foo.first(Thread.currentThread())).start();
    }
}
