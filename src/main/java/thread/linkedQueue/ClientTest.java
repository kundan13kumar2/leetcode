package thread.linkedQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTest {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Buffer buffer = new Buffer();
        service.execute(new Producer(buffer));
        service.execute(new Consumer(buffer));

        
    }
}
