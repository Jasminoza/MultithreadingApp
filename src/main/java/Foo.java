public class Foo implements Runnable{
    public void first(Runnable r) {
        System.out.print("first");
    }

    public void second(Runnable r) {
        System.out.print("second");
    }

    public void third(Runnable r) {
        System.out.print("third");
    }

    @Override
    public void run() {
        first(this);
        second(this);
        third(this);
    }
}