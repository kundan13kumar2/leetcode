package thread.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyDelay implements Delayed {

    String item;
    long expiryTime;
    long currentTime;

    public MyDelay(String item, long delay) {
        this.item = item;
        this.currentTime = System.currentTimeMillis();
        this.expiryTime = currentTime + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long delay = expiryTime - System.currentTimeMillis();
        return unit.convert(delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "MyDelay{" +
                "item='" + item + '\'' +
                ", expiryTime=" + expiryTime +
                ", currentTime=" + currentTime +
                '}';
    }
}
