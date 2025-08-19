package thread.linkedQueue;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {

    private Buffer buffer;
    AtomicInteger num = new AtomicInteger(0);

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            buffer.put(num.incrementAndGet());
        }
    }
}
