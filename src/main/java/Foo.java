import java.util.concurrent.atomic.AtomicBoolean;

public class Foo {
    public static AtomicBoolean firstFunctionDone = new AtomicBoolean(false);
    public static AtomicBoolean secondFunctionDone = new AtomicBoolean(false);

    public void first(Runnable r) {
        System.out.print("first");
        firstFunctionDone.set(true);
    }

    public void second(Runnable r) {
        while (!firstFunctionDone.get()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("second");
        secondFunctionDone.set(true);
    }

    public void third(Runnable r) {
        while (!firstFunctionDone.get() && !secondFunctionDone.get()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("third");
    }
}

