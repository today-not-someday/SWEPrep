package OOPS.ProducerConsumerQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer: " + Thread.currentThread().getName()+ " is consuming message : " + queue.take().value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
