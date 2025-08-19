package thread.waitNotify;

public class MovieCollection extends Thread {

    int total;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++)
                total += 100;
            this.notify();
        }
    }
}
