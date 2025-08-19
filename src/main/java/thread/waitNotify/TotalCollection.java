package thread.waitNotify;

public class TotalCollection {
    public static void main(String[] args) throws InterruptedException {
        MovieCollection mv = new MovieCollection();
        mv.start();
        synchronized (mv) {
            mv.wait();
        }
        System.out.println(mv.total);

    }
}
