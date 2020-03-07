package OOPS.ProducerConsumerQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A produced message =" + i);
            queue.add(new Message(i, "Message is " + i));

        }
    }
}
