package IPC_InterProcessCommunication.Producer_Consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        /*
        Message to process handling?
         */
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);

        Thread Tp = new Thread(p);
        Thread Tc = new Thread(c1);

        Tp.start();
        Tc.start();
    }
}
