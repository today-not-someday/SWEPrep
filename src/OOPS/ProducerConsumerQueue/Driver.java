package OOPS.ProducerConsumerQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Driver {

    public static void main(String[] args){

        BlockingQueue<Message> queue=new ArrayBlockingQueue<>(10);


        Thread producer=new Thread(new Producer(queue));
        Thread consumer1=new Thread(new Consumer(queue));
        Thread consumer2=new Thread(new Consumer(queue));

        consumer1.setName("Consumer 1");
        consumer2.setName("Consumer 2");

        producer.start();
        consumer1.start();
        consumer2.start();

    }
}
