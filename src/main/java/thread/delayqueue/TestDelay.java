package thread.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TestDelay {
    public static void main(String[] args) {

        final long delay = 10000;
        BlockingQueue<MyDelay> delayQueue = new DelayQueue<MyDelay>();

        AtomicInteger num = new AtomicInteger(0);

        //Produce Thread
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    int k = num.incrementAndGet();
                    MyDelay myDelay = new MyDelay("item " + k, delay);
                    delayQueue.add(myDelay);
                    //Thread.sleep(1000);

                }
            }
        }.start();


        //Consumer Thread
        new Thread() {

            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Consumed : " + delayQueue.take() + " : Curent Time: " + System.currentTimeMillis());
                         // Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Exception occurred consumer ");
                    }
                }
            }
        }.start();

    }
}
