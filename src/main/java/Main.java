import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(() -> foo.second(Thread.currentThread())).start();
        new Thread(() -> foo.third(Thread.currentThread())).start();
        new Thread(() -> foo.first(Thread.currentThread())).start();

//        CompletableFuture.runAsync(() -> foo.third(Thread.currentThread()));
//        CompletableFuture.runAsync(() -> foo.second(Thread.currentThread()));
//        CompletableFuture.runAsync(() -> foo.first(Thread.currentThread()));

    }
}
