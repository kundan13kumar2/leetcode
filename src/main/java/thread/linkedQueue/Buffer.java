package thread.linkedQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {

    private BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(1);

    public void get() {
        try {
            System.out.println("Consumed : " + buffer.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put(Integer element) {
        try {
            buffer.put(element);
            System.out.println("Produced : " + element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
